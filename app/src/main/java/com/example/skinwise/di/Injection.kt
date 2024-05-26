package com.example.skinwise.di

import android.content.Context
import com.example.skinwise.data.Repository
import com.example.skinwise.data.api.ApiConfig
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepo(context: Context) : Repository {
        val preferences = UserPreference.getInstance(context.dataStore)
        val token = runBlocking { preferences.getSession().first().token }
        val apiService = ApiConfig.getApiService(token)
        return Repository.getInstance(preferences,apiService)
    }

}