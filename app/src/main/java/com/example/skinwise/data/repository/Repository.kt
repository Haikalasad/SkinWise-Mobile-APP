package com.example.skinwise.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.skinwise.data.Result
import com.example.skinwise.data.api.ApiService
import com.example.skinwise.data.api.response.DoctorResponse
import com.example.skinwise.data.api.response.HospitalResponse
import com.example.skinwise.data.api.response.LoginResponse
import com.example.skinwise.data.api.response.RegisterResponse
import com.example.skinwise.data.api.response.updateResponse
import com.example.skinwise.data.model.UserModel
import com.example.skinwise.data.pref.UserPreference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class Repository(private val preferences: UserPreference, private val apiService: ApiService) {
    suspend fun register(nama:String,email:String,password:String,role:String) : Result<RegisterResponse> {
        return try{
            val response = apiService.register(nama,email,password,role)
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

    suspend fun login(email: String,password: String): Result<LoginResponse> {
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

    suspend fun getHospital(kota : String) : Result<HospitalResponse> {
        return try {
            val response = apiService.getHospital(kota)
            if(response.status == "fail"){
                Result.Error("Gagal mendapatkan list rumah sakit")
            }else{
                Result.Success(response)
            }
        } catch (e : Exception){
            Result.Error(e.message ?: "Unkown error occured")

        }
    }

    suspend fun getDoctors() : Result<DoctorResponse> {
        return try {
            val response = apiService.getDoctors()
            if(response.status == "fail"){
                Result.Error("Gagal mendapatkan list dokter")
            }else{
                Result.Success(response)
            }
        } catch (e : Exception){
            Result.Error(e.message ?: "Unkown error occured")

        }
    }


    suspend fun update(imageFile: MultipartBody.Part?, dataJson: RequestBody): Result<updateResponse> {
        return try {
            val response = withContext(Dispatchers.IO) {
                if (imageFile != null) {
                    apiService.update(imageFile, dataJson)
                } else {
                    apiService.update(null,dataJson)
                }
            }
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error occurred")
        }
    }

    fun getUser(): LiveData<UserModel> {
        return preferences.getSession().asLiveData()
    }


    suspend fun saveUserInfo(token: String) {
        preferences.saveUserInfo(token)
    }
    fun getSession(): Flow<UserModel> {
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