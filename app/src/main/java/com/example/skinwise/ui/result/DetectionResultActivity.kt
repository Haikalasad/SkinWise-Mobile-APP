package com.example.skinwise.ui.result

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.skinwise.data.api.ApiService
import com.example.skinwise.data.api.response.DataPredict
import com.example.skinwise.databinding.ActivityResultBinding
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.Executors

class DetectionResultActivity : AppCompatActivity() {
    private val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }
    private var file: File? = null
    private var isBack: Boolean = true
    private var compressingDone: MutableLiveData<Boolean> = MutableLiveData(false)

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

        Executors.newSingleThreadExecutor().execute {
            file = reduceFileImage(file as File)
            compressingDone.postValue(true)
        }

        compressingDone.observe(this) { isDone ->
            if (isDone) {
                file?.let { uploadImageAndClassify(it) }
            }
        }
    }

    private fun uploadImageAndClassify(file: File) {
        // Mengunggah gambar ke API dan mendapatkan hasil klasifikasi
        val retrofit = Retrofit.Builder()
            .baseUrl("http://35.219.121.162:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("image", file.name, requestFile)
        val token = "Bearer <token>" // Ganti dengan token yang sesuai

        lifecycleScope.launch {
            try {
                val response = apiService.uploadImage(token, body)
                displayResults(response.data)
            } catch (e: Exception) {
                Log.e(TAG, "Upload or classification failed", e)
                showToast("Failed to classify image")
            }
        }
    }

    private fun displayResults(data: DataPredict) {
        val imageUrl = data.link
        val name = data.name
        val step = data.step

        binding.disease.text = name
        binding.medicine.text = step

        Glide.with(this)
            .load(imageUrl)
            .into(binding.imageView)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

