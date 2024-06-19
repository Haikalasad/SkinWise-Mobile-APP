package com.example.skinwise.ui.hospital.favorite

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinwise.R

import com.example.skinwise.databinding.ActivityFavoriteHospitalBinding
import com.example.skinwise.ui.hospital.HospitalViewModel
import com.example.skinwise.ui.main.ViewModelFactory

class FavoriteHospitalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteHospitalBinding
    private lateinit var adapter: FavoriteHospitalsAdapter
    private lateinit var favoriteFactory: ViewModelFactory
    private val viewModel: HospitalViewModel by viewModels { favoriteFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        favoriteFactory = ViewModelFactory.getInstance(this)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Favorite Rumah Sakit"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow: Drawable? = ContextCompat.getDrawable(this, R.drawable.baseline_arrow_back_24)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        adapter = FavoriteHospitalsAdapter(viewModel)
        binding.rvListFavorite.layoutManager = LinearLayoutManager(this)
        binding.rvListFavorite.adapter = adapter
        viewModel.setLoading(true)

        viewModel.favoriteHospitals.observe(this) { hospital ->
            Handler().postDelayed({
                viewModel.setLoading(false)
                adapter.submitList(hospital)
            }, 1500)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            showLoading(isLoading)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showLoading(state: Boolean) {
        binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE
    }
}
