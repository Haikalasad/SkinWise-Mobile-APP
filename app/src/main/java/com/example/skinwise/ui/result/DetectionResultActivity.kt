package com.example.skinwise.ui.result

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityResultBinding
import org.tensorflow.lite.task.vision.classifier.Classifications

class DetectionResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    companion object {
        const val IMAGE_URI = "img_uri"
        const val TAG = "imagePicker"
        const val EXTRA_PICTURE = "extra_picture"
        const val EXTRA_IS_FROM_GALLERY = "extra_is_from_gallery"
        const val EXTRA_IS_BACK_CAMERA = "extra_is_back_camera"
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