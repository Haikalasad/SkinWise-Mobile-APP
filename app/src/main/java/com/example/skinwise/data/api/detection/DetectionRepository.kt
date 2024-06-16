package com.example.skinwise.data.api.detection

import com.example.skinwise.data.Result
import com.example.skinwise.data.api.ApiService
import com.example.skinwise.data.api.response.PredictResponse
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.repository.Repository
import okhttp3.MultipartBody

class DetectionRepository(private val preferences: UserPreference, private val apiService: DetectionApiService) {

    suspend fun predict(imageFile: MultipartBody.Part): Result<PredictResponse> {
        return try {
            val response = apiService.uploadImage(imageFile)
            if (response.status == "fail") {
                Result.Error("Gagal melakukan prediksi")
            } else {
                Result.Success(response)
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error occurred")
        }
    }


    companion object {
        @Volatile
        private var instance: DetectionRepository? = null
        fun getInstance(preferences: UserPreference, apiService: DetectionApiService): DetectionRepository =
            instance ?: synchronized(this) {
                instance ?: DetectionRepository(preferences,apiService)
            }.also { instance = it }
    }


}