package com.example.skinwise.data.api.detection

import com.example.skinwise.data.api.response.PredictResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface DetectionApiService {

    @Multipart
    @POST("/predict")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part
    ): PredictResponse
}