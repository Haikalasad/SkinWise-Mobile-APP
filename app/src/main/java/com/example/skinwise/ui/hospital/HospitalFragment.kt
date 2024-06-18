package com.example.skinwise.ui.hospital

import android.content.pm.PackageManager
import android.Manifest
import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinwise.R
import com.example.skinwise.adapter.HospitalAdapter
import com.example.skinwise.databinding.FragmentHospitalBinding
import com.example.skinwise.ui.main.ViewModelFactory
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale
import com.example.skinwise.data.Result
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult

class HospitalFragment : Fragment() {

    private lateinit var binding: FragmentHospitalBinding
    private lateinit var factory: ViewModelFactory
    private val viewModel: HospitalViewModel by viewModels { factory }
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var hospitalAdapter: HospitalAdapter
    private lateinit var locationCallback: LocationCallback

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHospitalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = ViewModelFactory.getInstance(requireContext())
        setHasOptionsMenu(true)

        hospitalAdapter = HospitalAdapter()
        binding.rvListHospital.adapter = hospitalAdapter
        binding.rvListHospital.layoutManager = LinearLayoutManager(requireContext())

        binding.toolbar.apply {
            setTitle(R.string.hospital_toolbar)
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        viewModel.hospitalResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Success -> {
                    hospitalAdapter.submitList(result.data.data?.hospitals)
                }
                is Result.Error -> {
                    Log.e("ListHospitalFragment", "Gagal mendapatkan list rumah sakit: ${result.data}")
                }
                else -> {}
            }
        }
        getCurrentLocation()
    }

    private fun getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            val locationManager = requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) && !locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                Toast.makeText(requireContext(), "Please enable location services", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            } else {
                val locationRequest = LocationRequest.create().apply {
                    interval = 10000
                    fastestInterval = 5000
                    priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                }

                locationCallback = object : LocationCallback() {
                    override fun onLocationResult(locationResult: LocationResult?) {
                        if (!isAdded) return  // Check if the fragment is still added

                        locationResult?.lastLocation?.let { location ->
                            val geocoder = Geocoder(requireContext(), Locale.getDefault())
                            val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                            if (addresses != null && addresses.isNotEmpty()) {
                                val address = addresses[0]
                                var city = address.subAdminArea
                                if (city.isNullOrEmpty()) {
                                    city = address.subAdminArea ?: address.locality
                                }
                                city?.let {
                                    Log.d("HospitalFragment", "City: $city")
                                    viewModel.getHospital(it)
                                }
                            } else {
                                Log.e("HospitalFragment", "No addresses found")
                            }
                        }
                    }
                }

                fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fusedLocationClient.removeLocationUpdates(locationCallback)  // Remove location updates when the fragment is destroyed
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation()
            }
        }
    }
}
