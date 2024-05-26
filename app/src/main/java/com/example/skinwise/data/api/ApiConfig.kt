package com.example.skinwise.data.api

import android.content.Context
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    val BASE_URL = " " //ganti pakek link localhost kalo mau coba di local

    fun getApiService(token : String) :ApiService{
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val authInterceptor = Interceptor{ chain ->
            val req = chain.request()
            val requestHeaders = req.newBuilder()
                .addHeader("Authorization","Bearer $token")
                //ini buat header token biar ga perlu di set ulang-ulang lagi
                .build()
            chain.proceed(requestHeaders)
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor).build()

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)
    }


}