package com.example.skinwise.ui.result

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.skinwise.R
import com.example.skinwise.data.Result
import com.example.skinwise.data.api.DetectionApiConfig
import com.example.skinwise.data.api.detection.DetectionApiService
import com.example.skinwise.data.api.response.PredictResponse
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import com.example.skinwise.databinding.ActivityDetectionBinding
import com.example.skinwise.di.Injection
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import java.io.File

class DetectionActivity : AppCompatActivity() {

    private lateinit var predictApiService: DetectionApiService
    private lateinit var userPreference: UserPreference
    private lateinit var binding: ActivityDetectionBinding

    private val viewModel: DetectionViewModel by viewModels {
        PredictViewModelFactory.getInstance(Injection.providePredictRepo(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userPreference = UserPreference.getInstance(applicationContext.dataStore)

        val token = runBlocking { userPreference.getSession().first().token }

        predictApiService = DetectionApiConfig.getApiService(token)

        supportActionBar?.hide()

        setupView()
    }

    private fun setupView() {
        binding.cameraXButton.setOnClickListener {
            startCameraX()
        }
        binding.galleryButton.setOnClickListener {
            startGallery()
        }
    }

    private fun startCameraX() {
        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this@DetectionActivity,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        } else {
            val intent = Intent(this@DetectionActivity, CameraActivity::class.java)
            launcherIntentCameraX.launch(intent)
        }
    }

    private val launcherIntentCameraX =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val imagePath = result.data?.getStringExtra("imagePath")
                imagePath?.let {
                    val imageFile = File(it)
                    val imageUri = Uri.fromFile(imageFile)
                    viewModel.analyzeImage(imageFile, imageUri) { result ->
                        when (result) {
                            is Result.Success -> navigateToDetectionResult(result.data, imageUri)
                            is Result.Error -> Toast.makeText(
                                this@DetectionActivity,
                                "Prediction failed: ${result.data}",
                                Toast.LENGTH_SHORT
                            ).show()
                            else -> {
                                Toast.makeText(
                                    this@DetectionActivity,
                                    "Prediction failed",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                } ?: run {
                    Toast.makeText(
                        this@DetectionActivity,
                        "Failed to retrieve image",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


    private fun startGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, getString(R.string.import_gallery))
        launcherIntentGallery.launch(chooser)
    }

    private val launcherIntentGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val selectedImage: Uri? = result.data?.data
                selectedImage?.let {
                    val imageFile = fromUriToFile(it, this@DetectionActivity)
                    viewModel.analyzeImage(imageFile, it) { result ->
                        when (result) {
                            is Result.Success -> navigateToDetectionResult(result.data, it)
                            is Result.Error -> Toast.makeText(
                                this@DetectionActivity,
                                "Prediction failed: ${result.data}",
                                Toast.LENGTH_SHORT
                            ).show()
                            else -> {
                                Toast.makeText(
                                    this@DetectionActivity,
                                    "Prediction failed",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                } ?: run {
                    Toast.makeText(
                        this@DetectionActivity,
                        "Failed to retrieve image",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    private fun navigateToDetectionResult(predictResponse: PredictResponse, imageUri: Uri) {
        val intent = Intent(this@DetectionActivity, DetectionResultActivity::class.java)
        intent.putExtra(DetectionResultActivity.EXTRA_PREDICTION_RESPONSE, predictResponse)
        intent.putExtra(DetectionResultActivity.EXTRA_IMAGE_URI, imageUri.toString())
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    this@DetectionActivity,
                    getString(R.string.permission_camera_not_granted),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            this@DetectionActivity,
            it
        ) == PackageManager.PERMISSION_GRANTED
    }

    companion object {
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
}
