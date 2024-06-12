package com.example.skinwise.ui.Consultation


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityConsultationBinding
import com.example.skinwise.ui.hospital.HospitalActivity
import com.example.skinwise.ui.main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ConsultationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityConsultationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val intent: Intent? = when (item.itemId) {
                R.id.action_home -> Intent(this, MainActivity::class.java)
                R.id.action_hospital -> Intent(this, HospitalActivity::class.java)
                R.id.action_consultation -> Intent(this, ConsultationActivity::class.java)
                else -> null
            }
            if (intent != null) {
                startActivity(intent)
            }
            true
        }

        setContentView(R.layout.activity_consultation)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Konsultasi"

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter
        TabLayoutMediator(
            tabLayout, viewPager
        ) { tab, position ->
            when (position) {
                0 -> tab.setText("List Dokter")
                1 -> tab.setText("Chat")
            }
        }.attach()
    }
}