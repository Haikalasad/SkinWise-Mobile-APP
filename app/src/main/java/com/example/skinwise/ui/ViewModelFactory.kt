package com.example.skinwise.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.skinwise.data.Repository
import com.example.skinwise.di.Injection
import com.example.skinwise.ui.login.LoginViewModel
import com.example.skinwise.ui.signup.SignupViewModel

class ViewModelFactory private constructor(private val repo:Repository) :
    ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupViewModel::class.java)){
            return SignupViewModel(repo) as T
        }
        if(modelClass.isAssignableFrom( LoginViewModel::class.java)){
            return LoginViewModel(repo) as T
        }
//        if(modelClass.isAssignableFrom( MainViewModel::class.java)){
//            return MainViewModel(repo) as T
//        }

        return super.create(modelClass)
    }


    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory {
            return instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepo(context))
            }.also { instance = it }
        }
    }

}