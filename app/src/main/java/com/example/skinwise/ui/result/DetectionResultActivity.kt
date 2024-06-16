package com.example.skinwise.ui.result

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.skinwise.data.api.response.PredictResponse

import com.bumptech.glide.Glide
import com.example.skinwise.databinding.ActivityResultBinding

class DetectionResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val predictResponse = intent.getParcelableExtra<PredictResponse>(EXTRA_PREDICTION_RESPONSE)
        val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)


        if (predictResponse != null && imageUriString != null) {
            displayPrediction(predictResponse, Uri.parse(imageUriString))
        } else {
            Toast.makeText(this, "No prediction data found", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun displayPrediction(predictResponse: PredictResponse, imageUri: Uri) {
        binding.disease.text = predictResponse.data.name
        binding.medicine.text = predictResponse.data.step


        Glide.with(this)
            .load(imageUri)
            .into(binding.imageView)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_PREDICTION_RESPONSE = "prediction_response"
        const val EXTRA_IMAGE_URI = "image_uri"
        const val EXTRA_PICTURE = "camera_picture"
        const val EXTRA_IS_BACK_CAMERA = "image_uri"
    }
}
