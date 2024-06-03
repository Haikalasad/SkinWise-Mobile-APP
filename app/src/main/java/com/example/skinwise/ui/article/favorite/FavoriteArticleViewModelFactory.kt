package com.example.skinwise.ui.article.favorite

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.skinwise.data.database.favoriteArticle.FavoriteArticleRepository

class FavoriteArticleViewModelFactory private constructor(
    private val application: Application,
    private val favoriteArticleRepository: FavoriteArticleRepository
) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: FavoriteArticleViewModelFactory? = null

        fun getInstance(application: Application, favoriteArticleRepository: FavoriteArticleRepository): FavoriteArticleViewModelFactory {
            return instance ?: synchronized(this) {
                instance ?: FavoriteArticleViewModelFactory(application, favoriteArticleRepository).also { instance = it }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteArticleViewModel::class.java)) {
            return FavoriteArticleViewModel(application, favoriteArticleRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
