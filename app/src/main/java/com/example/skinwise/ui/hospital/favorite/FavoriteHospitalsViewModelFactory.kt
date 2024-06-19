package com.example.skinwise.ui.hospital.favorite

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.skinwise.data.database.favoriteArticle.FavoriteArticleRepository
import com.example.skinwise.data.database.favoriteHospitals.FavoriteHospitalsRepository

class FavoriteHospitalsViewModelFactory private constructor(
    private val application: Application,
    private val favoriteHospitalsRepository: FavoriteHospitalsRepository
) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: FavoriteHospitalsViewModelFactory? = null

        fun getInstance(application: Application, favoriteHospitalsRepository: FavoriteHospitalsRepository):FavoriteHospitalsViewModelFactory {
            return instance ?: synchronized(this) {
                instance ?: FavoriteHospitalsViewModelFactory(application, favoriteHospitalsRepository).also { instance = it }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteHospitalViewModel::class.java)) {
            return FavoriteHospitalViewModel(application, favoriteHospitalsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
