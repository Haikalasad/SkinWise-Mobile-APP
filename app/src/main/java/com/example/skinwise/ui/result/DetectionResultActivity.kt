package com.example.skinwise.ui.result

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityResultBinding
import org.tensorflow.lite.task.vision.classifier.Classifications
import java.io.File

class DetectionResultActivity : AppCompatActivity() {
    private val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }
    private val appExecutor: AppExecutors by lazy { AppExecutors() }
    private var file: File? = null
    private var isBack: Boolean = true
    private var compressingDone: MutableLiveData<Boolean> = MutableLiveData(false)
    private var detectedIng: String? = null
    private var labels: Array<String>? = null
    private var confidences: FloatArray? = null

    companion object {
        const val EXTRA_PICTURE = "extra_picture"
        const val EXTRA_IS_FROM_GALLERY = "extra_is_from_gallery"
        const val EXTRA_IS_BACK_CAMERA = "extra_is_back_camera"
        private const val TAG = "DetectionResultActivity"
        private const val imageSize = 224
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupData()
    }

    private fun setupData() {
        file = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(EXTRA_PICTURE, File::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra(EXTRA_PICTURE) as File
        }
        isBack = intent.getBooleanExtra(EXTRA_IS_BACK_CAMERA, true)

        appExecutor.diskIO.execute {
            file = reduceFileImage(file as File)
            compressingDone.postValue(true)
        }

        compressingDone.observe(this) { isDone ->
            if (isDone) {
                file?.let { loadDetectionResults(it) }
            }
        }
    }

    private fun loadDetectionResults(file: File) {
        var image = BitmapFactory.decodeFile((file).path)
        val dimension = Math.min(image.width, image.height)
        image = ThumbnailUtils.extractThumbnail(image, dimension, dimension)
        image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false)
        showThumbnail(image)
        classifyImage(image)
    }

    private fun showThumbnail(result: Bitmap) {
        var resultShowed = result
        val isFromGallery = intent.getBooleanExtra(EXTRA_IS_FROM_GALLERY, false)
        if (!isFromGallery) {
            resultShowed = rotateBitmap(resultShowed, isBack)
        }
        binding.imageView.setImageBitmap(resultShowed)
    }

    private fun classifyImage(image: Bitmap?) {
        val imageUri = Uri.fromFile(file)  // Konversi file ke URI
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

    private fun showResults(results: List<Classifications>) {
        val topResult = results[0]
        val label = topResult.categories[0].label
        val score = topResult.categories[0].score

        fun Float.formatToString(): String {
            return String.format("%.2f%%", this * 100)
        }
        binding.disease.text = "$label ${score.formatToString()}"
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}