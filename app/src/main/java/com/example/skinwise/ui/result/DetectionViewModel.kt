package com.example.skinwise.ui.result

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.Result
import com.example.skinwise.data.api.detection.DetectionRepository
import com.example.skinwise.data.api.response.PredictResponse
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class DetectionViewModel(private val repository: DetectionRepository) : ViewModel() {

    fun analyzeImage(imageFile: File, imageUri: Uri, onResult: (Result<PredictResponse>) -> Unit) {
        val requestFile = imageFile.asRequestBody("image/*".toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("image", imageFile.name, requestFile)

        viewModelScope.launch {
            try {
                val result = repository.predict(body)
                onResult(result)
            } catch (e: Exception) {
                onResult(Result.Error(e.message ?: "Unknown error occurred"))
            }
        }
    }
}

