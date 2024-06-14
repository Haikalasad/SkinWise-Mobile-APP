package com.example.skinwise.ui.Result

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityDetectionresultBinding
import com.example.skinwise.ml.ModelWithMetadata2
import com.example.skinwise.ui.main.MainActivity
import com.example.skinwise.utils.AppExecutors
import com.example.skinwise.data.model.DetectionModel
import org.tensorflow.lite.support.image.TensorImage
import java.io.File
import java.io.IOException

class DetectionResultActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetectionresultBinding.inflate(layoutInflater) }
    private val appExecutor: AppExecutors by lazy { AppExecutors() }
    private var detectedIng: String? = null
    private var labels: Array<String>? = null
    private var confidences: FloatArray? = null
    private var file: File? = null
    private var isBack: Boolean = true
    private var compressingDone: MutableLiveData<Boolean> = MutableLiveData(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupData()
    }

    private fun setupData() {
        showLoading(true)
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
        showLoading(false)
        classifyImage(image)
    }

    private fun showThumbnail(result: Bitmap) {
        var resultShowed = result
        val isFromGallery = intent.getBooleanExtra(EXTRA_IS_FROM_GALLERY, false)
        if (!isFromGallery) {
            resultShowed = rotateBitmap(resultShowed, isBack)
        }
        binding.ivDetectionImage.setImageBitmap(resultShowed)
    }

    private fun classifyImage(image: Bitmap?) {
        try {
            val model = ModelWithMetadata2.newInstance(applicationContext)

            // Creates inputs for reference.
            val tensorImage = TensorImage.fromBitmap(image!!)

            // Runs model inference and gets result.
            val outputs = model.process(tensorImage)
            val probability = outputs.probabilityAsCategoryList

            // Extract the highest confidence label
            var maxPos = 0
            var maxConfidence = 0f
            for (i in probability.indices) {
                if (probability[i] > maxConfidence) {
                    maxConfidence = probability[i]
                    maxPos = i
                }
            }
            val classes = arrayOf("Melanocytic Nevi", "Melanoma", "Benign keratosis-like lesions", "Basal cell carcinoma", "Actinic keratoses", "Vascular lesions", "Dermatofibroma")

            this.labels = classes
            this.confidences = probability.toFloatArray()
            this.detectedIng = classes[maxPos]

            // Releases model resources if no longer used.
            handleDetectionResults()
            model.close()
        } catch (e: IOException) {
            // TODO Handle the exception
        }
    }

    private fun handleDetectionResults() {
        val labels = this.labels
        val confidences = this.confidences
        val detectedIng = this.detectedIng

        if (labels != null && confidences != null && detectedIng != null) {
            val listDetection = mutableListOf<DetectionModel>()

            var maxConfidence = 0.0f
            for (i in confidences.indices) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i]
                }
            }

            viewModel.searchIngredientByName(detectedIng).observe(this) { listResult ->
                if (listResult.isNotEmpty()) {
                    val result = listResult.first()
                    val data = DetectionModel(
                        result.ingId,
                        result.categoryName,
                        result.ingName,
                        result.isHave,
                        confidence = maxConfidence
                    )
                    viewModel.getUser().observe(this) { user ->
                        if (user != null) {
                            setupView(user.userId, listDetection, data, maxConfidence)
                        }
                    }
                } else {
                    handleNotDetected()
                }
            }
        }

        binding.btnBack.setOnClickListener {
            goToMain()
        }
    }

    private fun handleNotDetected() {
        binding.tvMostLikely.text = getString(R.string.detection_failed)
        binding.btnAddPantry.visibility = View.GONE
    }

//    private fun setupView(userId: Int, listDetection: MutableList<DetectionModel>, bestMatch: DetectionModel, confidence: Float) {
//        if (confidence > 0.75f) {
//            binding.tvMostLikely.text = getString(R.string.most_likely).format(bestMatch.ingName)
//        } else {
//            binding.tvMostLikely.text = getString(R.string.not_sure)
//            binding.tvNotConfident.text = getString(R.string.alternative_detection).format((confidence * 100).toInt().toString(), bestMatch.ingName)
//        }
//
//        if (bestMatch.isHave == true && confidence > 0.75f) {
//            binding.tvMostLikely.text = getString(R.string.already_in_pantry).format(bestMatch.ingName)
//            binding.btnAddPantry.visibility = View.GONE
//        } else {
//            binding.btnAddPantry.setOnClickListener {
//                viewModel.addPantryIngredient(userId, bestMatch.ingId).observe(this) { result ->
//                    when (result) {
//                        is Result.Success -> {
//                            showLoading(false)
//                            Toast.makeText(this, getString(R.string.ingredient_added).format(bestMatch.ingName), Toast.LENGTH_SHORT).show()
//                            goToMain()
//                        }
//                        is Result.Loading -> showLoading(true)
//                        is Result.Error -> {
//                            showLoading(false)
//                            val message = getString(R.string.add_ingredient_failed)
//                            Log.e(TAG, result.error + message)
//                            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//            }
//        }
//    }

    private fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    companion object {
        const val EXTRA_PICTURE = "extra_picture"
        const val EXTRA_IS_FROM_GALLERY = "extra_is_from_gallery"
        const val EXTRA_IS_BACK_CAMERA = "extra_is_back_camera"
        private val TAG = "DetectionResultActivity"
        private val imageSize = 224
    }
}
