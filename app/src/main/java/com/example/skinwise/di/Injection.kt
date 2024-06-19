package com.example.skinwise.di

import android.app.Application
import android.content.Context
import com.example.skinwise.data.repository.ArticleRepository
import com.example.skinwise.data.repository.Repository
import com.example.skinwise.data.api.ApiConfig
import com.example.skinwise.data.api.DetectionApiConfig
import com.example.skinwise.data.api.detection.DetectionRepository
import com.example.skinwise.data.database.favoriteHospitals.FavoriteHospitalsRepository
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {

    fun provideRepo(context: Context): Repository {
        val preferences = UserPreference.getInstance(context.dataStore)
        val token = runBlocking { preferences.getSession().first().token }
        val apiService = ApiConfig.getApiService(token)
        return Repository.getInstance(preferences, apiService)
    }

    fun providePredictRepo(context: Context): DetectionRepository{
        val preferences = UserPreference.getInstance(context.dataStore)
        val token = runBlocking { preferences.getSession().first().token }
        val apiService = DetectionApiConfig.getApiService(token)
        return DetectionRepository.getInstance(preferences, apiService)
    }



    fun provideFavoriteHospitalRepo(applicationContext: Context): FavoriteHospitalsRepository {
        return FavoriteHospitalsRepository(applicationContext.applicationContext as Application)
    }


    fun provideArticleRepo(): ArticleRepository {
        return ArticleRepository()
    }
}
