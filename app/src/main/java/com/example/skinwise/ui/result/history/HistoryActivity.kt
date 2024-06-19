package com.example.skinwise.ui.result.history

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinwise.R
import com.example.skinwise.adapter.HistoryAdapter
import com.example.skinwise.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private val historyViewModel: HistoryViewModel by viewModels { HistoryViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "History Scanning"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow: Drawable? = ContextCompat.getDrawable(this, R.drawable.baseline_arrow_back_24)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        val adapter = HistoryAdapter(historyViewModel)
        binding.rvListHistory.layoutManager = LinearLayoutManager(this)
        binding.rvListHistory.adapter = adapter

        historyViewModel.getAllHistory().observe(this, Observer { historyList ->
            historyList?.let {
                adapter.submitList(it)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
