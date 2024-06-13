package com.example.skinwise.ui.hospital

import android.content.pm.PackageManager
import android.Manifest
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.skinwise.R
import com.example.skinwise.databinding.FragmentHospitalBinding
import com.example.skinwise.ui.main.ViewModelFactory
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale

class HospitalFragment : Fragment() {

    private lateinit var binding: FragmentHospitalBinding
    private lateinit var factory: ViewModelFactory
    private val viewModel: HospitalViewModel by viewModels { factory }
    private lateinit var fusedLocationClient: FusedLocationProviderClient

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

        binding.toolbar.apply {
            setTitle(R.string.hospital_toolbar)

        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
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
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    val geocoder = Geocoder(requireContext(), Locale.getDefault())
                    val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                    if (addresses != null && addresses.isNotEmpty()) {
                        val city = addresses[0]?.locality
                        city?.let { viewModel.getHospital(it) }
                    }
                }
            }
        }
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
