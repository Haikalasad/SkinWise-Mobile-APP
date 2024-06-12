package com.example.skinwise.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.skinwise.data.repository.ArticleRepository
import com.example.skinwise.data.repository.Repository
import com.example.skinwise.di.Injection
import com.example.skinwise.ui.Consultation.ConsultationViewModel
import com.example.skinwise.ui.article.ArticleViewModel
import com.example.skinwise.ui.hospital.HospitalViewModel
import com.example.skinwise.ui.login.LoginViewModel
import com.example.skinwise.ui.signup.SignupViewModel

class ViewModelFactory private constructor(
    private val repository: Repository,
    private val articleRepository: ArticleRepository,
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java)->MainViewModel(repository) as T
            modelClass.isAssignableFrom(SignupViewModel::class.java) -> SignupViewModel(repository) as T
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository) as T
            modelClass.isAssignableFrom(ArticleViewModel::class.java) -> ArticleViewModel(articleRepository) as T
            modelClass.isAssignableFrom(HospitalViewModel::class.java) -> HospitalViewModel(repository) as T
            modelClass.isAssignableFrom(ConsultationViewModel::class.java) -> ConsultationViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory {
            return instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideRepo(context),
                    Injection.provideArticleRepo(),
                )
            }.also { instance = it }
        }
    }
}
