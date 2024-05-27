package com.example.skinwise.data

import com.example.skinwise.data.api.article.ArticleApiService
import com.example.skinwise.data.api.article.ArticleResponse
import com.example.skinwise.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArticleRepository(private val articleApiService: ArticleApiService) {

    suspend fun getArticles(query: String): Result<ArticleResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = articleApiService.getArticle(query).execute()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        Result.Success(body)
                    } else {
                        Result.Error("Response body is null")
                    }
                } else {
                    Result.Error("Failed to fetch articles")
                }
            } catch (e: Exception) {
                Result.Error(e.message ?: "Unknown error occurred")
            }
        }
    }
}
