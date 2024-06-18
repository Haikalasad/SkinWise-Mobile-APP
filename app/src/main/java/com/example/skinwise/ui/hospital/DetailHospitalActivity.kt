package com.example.skinwise.ui.hospital

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityDetailHospitalBinding

class DetailHospitalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHospitalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val hospitalName = intent.getStringExtra("hospital_name")
        val hospitalCity = intent.getStringExtra("hospital_kota")
        val hospitalProvince = intent.getStringExtra("hospital_provinsi")
        val hospitalInformation = intent.getStringExtra("hospital_info")
        val hospitalContact = intent.getStringExtra("hospital_kontak")
        val hospitalRating = intent.getStringExtra("hospital_rating")
        val hospitalImageUrl = intent.getStringExtra("hospital_image_url")
        val hospitalLocation = intent.getStringExtra("hospital_location")
        val dermaAvail  = intent.getIntExtra("derma_avail",0)

        binding.tvHospitalName.text = hospitalName
        binding.tvHospitalCity.text = hospitalCity
        binding.tvHospitalProvince.text = hospitalProvince
        binding.tvPhone.text = hospitalContact
        binding.tvAdditionalInfo.text = hospitalInformation
        binding.tvRate.text = hospitalRating.toString()
        Glide.with(this).load(hospitalImageUrl).into(binding.pictHospital)

        binding.ivMaps.setOnClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(hospitalLocation))
            startActivity(webIntent)
        }



        if (dermaAvail == 1) {
            binding.ivDermatologistAvail.setColorFilter(Color.GREEN) // Tint hijau
            binding.tvDermatologistAvail.text = getString(R.string.dermatologist_available)
        } else {
            binding.ivDermatologistAvail.setColorFilter(Color.RED) // Tint merah
            binding.tvDermatologistAvail.text = getString(R.string.dermatologist_unavailable)
        }

        binding.tvAdditionalInfo.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(hospitalInformation))
            startActivity(browserIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.info_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.action_faq -> {
                Toast.makeText(this, "FAQ clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
