package com.example.skinwise.data.api.article

import com.example.skinwise.data.api.response.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApiService {
    @GET("/v2/everything")
    fun getArticle(
        @Query("q") q: String,
    ): Call<ArticleResponse>
}


// endpoint untuk ARTICLE API (sebelum)