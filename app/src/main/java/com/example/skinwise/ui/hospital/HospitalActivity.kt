package com.example.skinwise.ui.hospital

import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityHospitalBinding
import com.example.skinwise.ui.main.ViewModelFactory
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import android.Manifest
import android.content.Intent
import com.example.skinwise.ui.Consultation.ConsultationActivity
import com.example.skinwise.ui.main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Locale


class HospitalActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHospitalBinding
    private lateinit var factory: ViewModelFactory
    private val viewModel : HospitalViewModel by viewModels { factory }
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        factory = ViewModelFactory.getInstance(this)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Rumah Sakit"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val intent: Intent? = when (item.itemId) {
                R.id.action_home -> Intent(this, MainActivity::class.java)
                R.id.action_hospital -> Intent(this, HospitalActivity::class.java)
                // R.id.action_scan -> Intent(this, ScanActivity::class.java)
                R.id.action_consultation -> Intent(this, ConsultationActivity::class.java)
                // R.id.action_profile -> Intent(this, ProfileActivity::class.java)
                else -> null
            }
            if (intent != null) {
                startActivity(intent)
            }
            true
        }

        val upArrow: Drawable? = ContextCompat.getDrawable(this, R.drawable.baseline_arrow_back_24)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getCurrentLocation()

    }

    private fun getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    val geocoder = Geocoder(this, Locale.getDefault())
                    val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                    if (addresses != null) {
                        if (addresses.isNotEmpty()) {
                            val city = addresses[0]?.locality
                            if (city != null) {
                                viewModel.getHospital(city)
                            }
                        }
                    }
                }
            }
        }
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getCurrentLocation()
            }
        }
    }
}