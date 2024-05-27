package com.example.skinwise.data.api.article

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApiService {
    @GET("/v2/everything")
    fun getArticle(
        @Query("q") q: String,
    ): Call<ArticleResponse>
}