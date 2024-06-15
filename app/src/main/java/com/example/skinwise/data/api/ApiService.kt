package com.example.skinwise.data.api

import com.example.skinwise.data.api.response.DoctorResponse
import com.example.skinwise.data.api.response.HospitalResponse
import com.example.skinwise.data.api.response.LoginResponse
import com.example.skinwise.data.api.response.PredictResponse
import com.example.skinwise.data.api.response.RegisterResponse
import okhttp3.MultipartBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("/register")
    suspend fun register(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("nama") nama: String,
        @Field("role") role : String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("/hospitals")
    suspend fun getHospital(
        @Query("kota") kota: String,
    ): HospitalResponse

    @GET("/doctors")
    suspend fun getDoctors() : DoctorResponse

    @Multipart
    @POST("/predict")
    suspend fun uploadImage(
        @Header("Authorization") authHeader: String,
        @Part image: MultipartBody.Part
    ): PredictResponse
}