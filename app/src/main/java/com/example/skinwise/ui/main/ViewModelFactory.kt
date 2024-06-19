package com.example.skinwise.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.skinwise.data.database.favoriteHospitals.FavoriteHospitalsRepository
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import com.example.skinwise.data.repository.ArticleRepository
import com.example.skinwise.data.repository.Repository
import com.example.skinwise.di.Injection
import com.example.skinwise.ui.Consultation.ConsultationViewModel
import com.example.skinwise.ui.article.ArticleViewModel
import com.example.skinwise.ui.hospital.HospitalViewModel
import com.example.skinwise.ui.login.LoginViewModel
import com.example.skinwise.ui.profile.EditProfileViewModel
import com.example.skinwise.ui.result.DetectionViewModel
import com.example.skinwise.ui.signup.SignupViewModel

class ViewModelFactory private constructor(
    private val repository: Repository,
    private val articleRepository: ArticleRepository,
    private val favoriteHospitalsRepository: FavoriteHospitalsRepository,
    private val userPreference: UserPreference
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository) as T
            modelClass.isAssignableFrom(SignupViewModel::class.java) -> SignupViewModel(repository) as T
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository) as T
            modelClass.isAssignableFrom(ArticleViewModel::class.java) -> ArticleViewModel(articleRepository) as T
            modelClass.isAssignableFrom(HospitalViewModel::class.java) -> HospitalViewModel(repository, favoriteHospitalsRepository) as T
            modelClass.isAssignableFrom(ConsultationViewModel::class.java) -> ConsultationViewModel(repository) as T
            modelClass.isAssignableFrom(EditProfileViewModel::class.java) -> EditProfileViewModel(repository, userPreference) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory {
            return instance ?: synchronized(this) {
                val dataStore = context.dataStore
                val userPreference = UserPreference.getInstance(dataStore)
                val repository = Injection.provideRepo(context)
                val articleRepository = Injection.provideArticleRepo()
                val favoriteHospitalRepo = Injection.provideFavoriteHospitalRepo(context.applicationContext) // Use applicationContext here
                ViewModelFactory(repository, articleRepository, favoriteHospitalRepo, userPreference).also { instance = it }
            }
        }

    }
}
