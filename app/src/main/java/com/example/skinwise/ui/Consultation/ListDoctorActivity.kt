//package com.example.skinwise.ui.Consultation
//
//import android.graphics.drawable.Drawable
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.activity.viewModels
//import androidx.core.content.ContextCompat
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.skinwise.R
//import com.example.skinwise.adapter.DoctorAdapter
//import com.example.skinwise.data.database.favoriteArticle.FavoriteArticleRepository
//import com.example.skinwise.databinding.ActivityArticleBinding
//import com.example.skinwise.databinding.ActivityListDoctorBinding
//import com.example.skinwise.ui.article.ArticleViewModel
//import com.example.skinwise.ui.article.favorite.FavoriteArticleViewModel
//import com.example.skinwise.ui.article.favorite.FavoriteArticleViewModelFactory
//import com.example.skinwise.ui.main.ViewModelFactory
//
//class ListDoctorActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityListDoctorBinding
//    private lateinit var factory: ViewModelFactory
//    private val viewModel: ConsultationViewModel by viewModels { factory }
//    private lateinit var doctorAdapter :DoctorAdapter
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityListDoctorBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        factory = ViewModelFactory.getInstance(this)
//
//        setSupportActionBar(binding.toolbar)
//        supportActionBar?.title = "Konsultasi Dokter"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        val upArrow: Drawable? = ContextCompat.getDrawable(this, R.drawable.baseline_arrow_back_24)
//        supportActionBar?.setHomeAsUpIndicator(upArrow)
//
//
//        doctorAdapter = DoctorAdapter()
//        binding.rvListArticle.adapter = doctorAdapter
//
//        binding.rvListArticle.layoutManager = LinearLayoutManager(this)
//
//        viewModel.doctors.observe(this){
//            doctorAdapter.submitList(it)
//        }
//
//        viewModel.fetchListDoctors()
//
//    }
//}