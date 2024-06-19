package com.example.skinwise.ui.result

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.skinwise.data.api.response.PredictResponse

import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.api.response.HospitalItem
import com.example.skinwise.data.model.ArticleModel
import com.example.skinwise.data.repository.ArticleRepository
import com.example.skinwise.databinding.ActivityResultBinding
import com.example.skinwise.ui.hospital.HospitalViewModel
import com.example.skinwise.ui.main.ViewModelFactory
import com.example.skinwise.data.Result
import com.example.skinwise.data.database.HistoryScan.History
import com.example.skinwise.ui.article.ArticleActivity
import com.example.skinwise.ui.result.history.HistoryViewModel

class DetectionResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var articleRepository: ArticleRepository

    private val hospitalViewModel: HospitalViewModel by viewModels { ViewModelFactory.getInstance(this) }
    private val historyViewModel: HistoryViewModel by viewModels { HistoryViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        articleRepository = ArticleRepository()

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Hasil Deteksi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow: Drawable? = ContextCompat.getDrawable(this, R.drawable.baseline_arrow_back_24)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        val isFromHistory = intent.getBooleanExtra(EXTRA_FROM_HISTORY, false)

        if (isFromHistory) {

            val diseaseName = intent.getStringExtra(HISTORY_DISEASE)
            val medicine = intent.getStringExtra(HISTORY_MEDICINE)
            val imageUriString = intent.getStringExtra(HISTORY_IMAGE)
            val confidence = intent.getDoubleExtra(HISTORY_CONFIDENCE, 0.0)

            val confidenceFormatted = String.format("%.2f", confidence * 100)

            val diseaseText = "$diseaseName $confidenceFormatted%"

            binding.disease.text = diseaseText
            binding.medicine.text = medicine

            Glide.with(this)
                .load(imageUriString)
                .into(binding.imageView)

            displayArticlesByDisease(diseaseName ?: "")


        } else {
            val predictResponse = intent.getParcelableExtra<PredictResponse>(EXTRA_PREDICTION_RESPONSE)
            val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)

            if (predictResponse != null && imageUriString != null) {
                displayPrediction(predictResponse, Uri.parse(imageUriString))
            } else {
                Toast.makeText(this, "No prediction data found", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        hospitalViewModel.hospitalResult.observe(this, Observer { result ->
            when (result) {
                is Result.Success -> {
                    val hospitals = result.data.data?.hospitals?.filterNotNull()
                    if (hospitals != null && hospitals.isNotEmpty()) {
                        displayHospitals(hospitals.take(2))
                    }
                }
                is Result.Error -> {
                    Toast.makeText(this, "Error fetching hospitals", Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        })
        hospitalViewModel.getHospital("Surabaya")


        binding.btnArticle.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            startActivity(intent)
        }
    }


    private fun displayHospitals(hospitals: List<HospitalItem>) {
        if (hospitals.isNotEmpty()) {
            binding.tvHospital1.text = hospitals[0].nama
            binding.tvHospital1Address.text = hospitals[0].alamat
            binding.tvHospital1Rate.text = hospitals[0].rating.toString()
            Glide.with(this)
                .load(hospitals[0].urlGambar)
                .into(binding.ivHospital1)

            if (hospitals.size > 1) {
                binding.tvHospital2.text = hospitals[1].nama
                binding.tvHospital2Address.text = hospitals[1].alamat
                binding.tvHospital2Rate.text = hospitals[1].rating.toString()
                Glide.with(this)
                    .load(hospitals[1].urlGambar)
                    .into(binding.ivHospital2)
            }

        }
    }

    private fun displayPrediction(predictResponse: PredictResponse, imageUri: Uri) {
        val diseaseName = predictResponse.data.name
        val confidence = predictResponse.data.confidence

        val confidenceFormatted = String.format("%.2f", confidence * 100)

        val diseaseText = "$diseaseName $confidenceFormatted%"

        binding.disease.text = diseaseText
        binding.medicine.text = predictResponse.data.step


        displayArticlesByDisease(diseaseName)

        Glide.with(this)
            .load(imageUri)
            .into(binding.imageView)

        val history = History(
            diseaseName = diseaseName,
            medicine = predictResponse.data.step,
            image = imageUri.toString(),
            confidence = confidence,
            date = System.currentTimeMillis().toString()
        )
        historyViewModel.insert(history)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



    private fun displayArticlesByDisease(diseaseName: String) {
        val articles = articleRepository.getArticlesByCategory(diseaseName)

        if (articles.isNotEmpty()) {
            displayArticle(articles[0], binding.tittlearticle1, binding.dateArticle1, binding.pictArticle1)

            if (articles.size > 1) {
                displayArticle(articles[1], binding.tittlearticle2, binding.dateArticle2, binding.pictArticle2)
            } else {
                binding.tittlearticle2.visibility = View.GONE
                binding.dateArticle2.visibility = View.GONE
                binding.pictArticle2.visibility = View.GONE
            }
        } else {
            binding.tittlearticle1.visibility = View.GONE
            binding.dateArticle1.visibility = View.GONE
            binding.pictArticle1.visibility = View.GONE
            binding.tittlearticle2.visibility = View.GONE
            binding.dateArticle2.visibility = View.GONE
            binding.pictArticle2.visibility = View.GONE
        }
    }

    private fun displayArticle(article: ArticleModel, titleTextView: TextView, dateTextView: TextView, imageView: ImageView) {
        titleTextView.text = article.title
        dateTextView.text = article.date
        Glide.with(this)
            .load(article.imageUrl)
            .into(imageView)
    }


    companion object {
        const val EXTRA_PREDICTION_RESPONSE = "prediction_response"
        const val EXTRA_IMAGE_URI = "image_uri"
        const val EXTRA_PICTURE = "camera_picture"
        const val EXTRA_IS_BACK_CAMERA = "image_uri"

        const val HISTORY_DISEASE = "history_disease"
        const val HISTORY_MEDICINE = "history_medicine"
        const val HISTORY_CONFIDENCE = "history_confidence"
        const val HISTORY_IMAGE = "history_image"
        const val HISTORY_DATE = "history_date"

        const val EXTRA_FROM_HISTORY = "from_history"
    }
}
