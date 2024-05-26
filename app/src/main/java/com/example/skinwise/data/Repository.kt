package com.example.skinwise.data

import com.example.skinwise.data.api.ApiService
import com.example.skinwise.data.api.response.LoginResponse
import com.example.skinwise.data.api.response.RegisterResponse
import com.example.skinwise.data.model.loginModel
import com.example.skinwise.data.pref.UserPreference
import kotlinx.coroutines.flow.Flow

class Repository(private val preferences: UserPreference, private val apiService: ApiService) {

    suspend fun register(nama:String,email:String,password:String) : Result<RegisterResponse>{
        return try{
            val response = apiService.register(nama,email,password)
            if(response.status == "fail"){
                Result.Error("Registrasi gagal")
            }else{
                Result.Success(response)
            }
        }
        catch (e :Exception){
            Result.Error(e.message ?: "Unknown error occurred")
        }
    }

    suspend fun login(email: String,password: String): Result<LoginResponse>{
        return try {
            val response = apiService.login(email, password)
            if (response.status == "fail") {
                Result.Error("Login gagal")
            } else {
                Result.Success(response)
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error occurred")
        }
    }


    suspend fun SaveUserInfo(token: String) {
        preferences.SaveUserInfo(token)
    }
    fun getSession(): Flow<loginModel> {
        return preferences.getSession()
    }

    suspend fun logout() {
        preferences.logout()
    }

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(preferences: UserPreference, apiService: ApiService): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(preferences,apiService)
            }.also { instance = it }
    }


}