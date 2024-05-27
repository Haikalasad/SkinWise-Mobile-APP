package com.example.skinwise.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.ArticleRepository
import com.example.skinwise.data.api.article.ArticleResponse
import kotlinx.coroutines.launch
import com.example.skinwise.data.Result

class ArticleViewModel(private val repository: ArticleRepository) : ViewModel()  {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _articles = MutableLiveData<Result<ArticleResponse>>()
    val articles: LiveData<Result<ArticleResponse>> = _articles

    fun fetchArticles(query: String) {
        viewModelScope.launch {
            val result = repository.getArticles(query)
            _articles.value = result
        }
    }

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }


}