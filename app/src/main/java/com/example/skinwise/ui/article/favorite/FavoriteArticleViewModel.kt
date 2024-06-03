package com.example.skinwise.ui.article.favorite

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.database.favoriteArticle.FavoriteArticleRepository
import com.example.skinwise.data.database.favoriteArticle.favoriteArticle
import kotlinx.coroutines.launch

class FavoriteArticleViewModel(
    private val application: Application,
    private val favoriteArticleRepository: FavoriteArticleRepository
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    val favoriteArticles: LiveData<List<favoriteArticle>> = favoriteArticleRepository.getAllFavoriteArticle()

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }

    fun deleteByTitle(title: String) {
        viewModelScope.launch {
            favoriteArticleRepository.deleteByTitle(title)
            Toast.makeText(application, "$title telah dihapus dari favorit", Toast.LENGTH_SHORT).show()
        }
    }

    fun insertFavoriteArticle(article: favoriteArticle) {
        viewModelScope.launch {
            favoriteArticleRepository.insert(article)
            Toast.makeText(application, "${article.title} added to favorites", Toast.LENGTH_SHORT).show()
        }
    }
}
