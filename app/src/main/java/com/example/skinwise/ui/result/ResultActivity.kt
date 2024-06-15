//package com.example.skinwise.ui.Result
//
//import android.net.Uri
//import android.os.Bundle
//import android.provider.MediaStore
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.lifecycleScope
//import com.example.skinwise.R
//import com.example.skinwise.databinding.ActivityResultBinding
//import org.tensorflow.lite.task.vision.classifier.ImageClassifier
//import org.tensorflow.lite.task.vision.classifier.Classifications
//import org.tensorflow.lite.support.image.TensorImage
//import org.tensorflow.lite.support.common.FileUtil
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//class ResultActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityResultBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityResultBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Set toolbar
//        setSupportActionBar(binding.toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        // Get image URI from intent
//        val imageUri = intent.getStringExtra(EXTRA_IMG)?.let { Uri.parse(it) }
//
//        imageUri?.let {
//            binding.imageView.setImageURI(it)
//            analyzeImage(it)
//        }
//    }
//
//    private fun analyzeImage(imageUri: Uri) {
//        lifecycleScope.launch {
//            val image = loadImage(imageUri)
//            val results = classifyImage(image)
//            displayResults(results)
//        }
//    }
//
//    private suspend fun loadImage(imageUri: Uri): TensorImage {
//        return withContext(Dispatchers.IO) {
//            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
//            TensorImage.fromBitmap(bitmap)
//        }
//    }
//
//    private suspend fun classifyImage(image: TensorImage): List<Classifications> {
//        return withContext(Dispatchers.IO) {
//            val modelFile = FileUtil.loadMappedFile(this@ResultActivity, "model_with_metadata.tflite")
//            val options = ImageClassifier.ImageClassifierOptions.builder()
//                .setMaxResults(1)
//                .build()
//            val classifier = ImageClassifier.createFromFile(this@ResultActivity, modelFile, options)
//            classifier.classify(image)
//        }
//    }
//
//    private fun displayResults(results: List<Classifications>) {
//        if (results.isNotEmpty() && results[0].categories.isNotEmpty()) {
//            val category = results[0].categories[0]
//            val label = category.label
//            val score = category.score
//
//            binding.disease.text = label
//            binding.descriptiondisease.text = String.format("Confidence: %.2f%%", score * 100)
//        } else {
//            binding.disease.text = getString(R.string.no_disease_detected)
//            binding.descriptiondisease.text = getString(R.string.try_again)
//        }
//    }
//
//    companion object {
//        const val EXTRA_IMG = "extra_image_uri"
//        const val EXTRA_RESULT = "extra_result"
//    }
//}
