package com.example.skinwise.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityMainBinding
import com.example.skinwise.ui.HomeFragment
import com.example.skinwise.ui.profile.ProfileFragment
import com.example.skinwise.ui.Consultation.ConsultationFragment
import com.example.skinwise.ui.result.DetectionActivity
import com.example.skinwise.ui.hospital.HospitalFragment
import com.example.skinwise.ui.welcome.WelcomeActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getSession().observe(this) { user ->
            if (!user.isLogin) {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            }
        }

        // Hide the action bar
        supportActionBar?.hide()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set background to null
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.action_home -> selectedFragment = HomeFragment()
                R.id.action_profile -> selectedFragment = ProfileFragment()
                R.id.action_hospital -> selectedFragment = HospitalFragment()
                R.id.action_consultation-> selectedFragment = ConsultationFragment()
            }

            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit()
            }
            true
        }

        // Set default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }
        // Handle floating action button click
        binding.fabScan.setOnClickListener {
            goToDetection()
        }
    }

    private fun goToDetection() {
        val intent = Intent(this@MainActivity, DetectionActivity::class.java)
        startActivity(intent)
    }
}
