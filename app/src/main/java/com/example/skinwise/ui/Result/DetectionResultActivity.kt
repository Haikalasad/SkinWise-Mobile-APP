package com.example.skinwise.ui.Result

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityDetectionresultBinding
import com.example.skinwise.ml.ModelWithMetadata2
import com.example.skinwise.ui.main.MainActivity
import com.example.skinwise.data.model.DetectionModel
import com.example.skinwise.databinding.ActivityResultBinding
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.task.vision.classifier.Classifications
import java.io.File
import java.io.IOException

class DetectionResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    companion object {
        const val IMAGE_URI = "img_uri"
        const val TAG = "imagePicker"
        const val RESULT_TEXT = "result_text"
        const val REQUEST_HISTORY_UPDATE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)

        // TODO: Menampilkan hasil gambar, prediksi, dan confidence score.

        // menerima sebuah URI gambar dari intent
        val imageUriString = intent.getStringExtra(IMAGE_URI)
        if (imageUriString != null) {
            val imageUri = Uri.parse(imageUriString)
            displayImage(imageUri)
            classifyImage(imageUri)
        } else {
            Log.e(TAG, "No image URI provided")
            finish()
        }
    }

    // menampilkan gambar yang diterima dari URI ke suatu ImageView
    private fun displayImage(uri: Uri) {
        Log.d(TAG, "Displaying image: $uri")
        binding.imageView.setImageURI(uri)
    }

    //klasifikasikan gambar yang diterima dari URI
    private fun classifyImage(imageUri: Uri) {
        val imageClassifierHelper = ImageClassifierHelper(
            contextValue = this,
            classifierListenerValue = object : ImageClassifierHelper.ClassifierListener {
                override fun onError(errorMsg: String) {
                    Log.d(TAG, "Error: $errorMsg")
                    showToast(errorMsg)
                }

                override fun onResults(results: List<Classifications>?, inferenceTime: Long) {
                    results?.let { showResults(it) }
                }
            }
        )
        imageClassifierHelper.classifyStaticImage(imageUri)
    }

    //tampilkan hasil klasifikasi gambar
    private fun showResults(results: List<Classifications>) {
        val topResult = results[0] //Memilih hasil teratas dari list results
        val label = topResult.categories[0].label //Mengambil label dan skor dari kategori teratas
        val score = topResult.categories[0].score

        fun Float.formatToString(): String {
            return String.format("%.2f%%", this * 100)
        }
        binding.disease.text = "$label ${score.formatToString()}"
    }

    //pesan toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}