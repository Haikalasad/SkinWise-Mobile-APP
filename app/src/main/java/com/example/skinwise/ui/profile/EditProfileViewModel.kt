package com.example.skinwise.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.Result
import com.example.skinwise.data.repository.Repository
import com.example.skinwise.data.api.response.updateResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class EditProfileViewModel(private val repository: Repository) : ViewModel() {
    private val _updateResult = MutableStateFlow<Result<updateResponse>?>(null)
    val updateResult: StateFlow<Result<updateResponse>?> get() = _updateResult.asStateFlow()

    fun updateProfile(imageFile: File?, name: String, email: String) {
        val dataJson = """{
            "name": "$name",
            "email": "$email"
        }"""
        val dataPart = dataJson.toRequestBody("application/json".toMediaTypeOrNull())

        val imagePart = imageFile?.let {
            val requestFile = it.asRequestBody("image/jpeg".toMediaTypeOrNull())
            MultipartBody.Part.createFormData("image", it.name, requestFile)
        }

        viewModelScope.launch {
            val result = repository.update(imagePart, dataPart)
            _updateResult.emit(result)
        }
    }
}

