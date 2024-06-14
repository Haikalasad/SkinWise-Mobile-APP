package com.example.skinwise.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.repository.ArticleRepository
import kotlinx.coroutines.launch
import com.example.skinwise.data.model.ArticleModel
import kotlinx.coroutines.delay


class ArticleViewModel(private val articleRepository: ArticleRepository) : ViewModel() {

    private val _articles = MutableLiveData<List<ArticleModel>>()
    val articles: LiveData<List<ArticleModel>> = _articles

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        fetchArticles()
    }

    fun fetchArticles(query: String = "") {
        viewModelScope.launch {
            _isLoading.value = true
            delay(1000)
            val articlesList = articleRepository.getAllArticle().filter {
                it.title.contains(query, ignoreCase = true) || it.content.contains(query, ignoreCase = true)
            }
            _articles.value = articlesList
            _isLoading.value = false
        }
    }


    fun getArticleById(id: Int): ArticleModel? {

        return articleRepository.getArticleById(id)
    }
}

