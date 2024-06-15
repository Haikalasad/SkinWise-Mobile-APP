package com.example.skinwise.data.api

import com.example.skinwise.data.api.response.DoctorResponse
import com.example.skinwise.data.api.response.HospitalResponse
import com.example.skinwise.data.api.response.LoginResponse
import com.example.skinwise.data.api.response.RegisterResponse
import com.example.skinwise.data.api.response.updateResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
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
    @PATCH("/update")
    suspend fun update(
        @Part image: MultipartBody.Part?,
        @Part("data") data: RequestBody
    ): updateResponse






}