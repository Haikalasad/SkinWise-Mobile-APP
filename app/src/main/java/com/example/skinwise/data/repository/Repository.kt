package com.example.skinwise.data.repository

import com.example.skinwise.data.Result
import com.example.skinwise.data.api.ApiService
import com.example.skinwise.data.api.response.DoctorResponse
import com.example.skinwise.data.api.response.HospitalResponse
import com.example.skinwise.data.api.response.LoginResponse
import com.example.skinwise.data.api.response.RegisterResponse
import com.example.skinwise.data.model.DoctorModel
import com.example.skinwise.data.model.UserModel
import com.example.skinwise.data.pref.UserPreference
import kotlinx.coroutines.flow.Flow

class Repository(private val preferences: UserPreference, private val apiService: ApiService) {

//    fun getAllDoctors(): List<DoctorModel> {
//        return doctors
//    }
//
//    private val doctors: List<DoctorModel> = listOf(
//        DoctorModel(
//            doctorId ="1",
//            name = "jhon doe",
//            email = "jhon@gmail.com",
//            photoUrl = "https://img.freepik.com/free-photo/smiling-doctor-with-strethoscope-isolated-grey_651396-974.jpg?w=1800&t=st=1717772918~exp=1717773518~hmac=fbef65044e0a888a9be4a5ebea2ca21c4725549b8be8d9bfe1c880165722b9d7"
//
//        ),
//        DoctorModel(
//            doctorId ="2",
//            name = "Ini dokter 2",
//            email = "jhon@gmail.com",
//            photoUrl = "https://img.freepik.com/free-photo/smiling-doctor-with-strethoscope-isolated-grey_651396-974.jpg?w=1800&t=st=1717772918~exp=1717773518~hmac=fbef65044e0a888a9be4a5ebea2ca21c4725549b8be8d9bfe1c880165722b9d7"
//
//        )
//
//    )
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