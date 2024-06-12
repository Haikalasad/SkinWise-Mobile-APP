package com.example.skinwise.ui.hospital

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.api.response.HospitalResponse
import com.example.skinwise.data.repository.Repository
import kotlinx.coroutines.launch
import com.example.skinwise.data.Result


class HospitalViewModel(private val hospitalRepository: Repository) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _hospitalResult = MutableLiveData<Result<HospitalResponse>>()
    val hospitalResult: LiveData<Result<HospitalResponse>> = _hospitalResult


    fun getHospital(kota : String) {
        viewModelScope.launch {
            val result = hospitalRepository.getHospital(kota)
            _hospitalResult.value = result
        }
    }

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }
}







//    private val _hospital = MutableLiveData<List<HospitalModel>>()
//    val hospital: LiveData<List<HospitalModel>> = _hospital
//
//    private val _isLoading = MutableLiveData<Boolean>()
//    val isLoading: LiveData<Boolean> = _isLoading
//
//    init {
//        fetchHospitals()
//    }
//
//    fun fetchHospitals(query: String = "") {
//        viewModelScope.launch {
//            _isLoading.value = true
//            delay(1000)
//            val hospitalList = hospitalRepository.getAllHospital().filter {
//                it.hospitalName.contains(query, ignoreCase = true) || it.city.contains(query, ignoreCase = true)
//            }
//            _hospital.value = hospitalList
//            _isLoading.value = false
//        }
//    }
//    fun getHospitalById(id: Int): HospitalModel? {
//
//        return hospitalRepository.getArticleById(id)
//    }
