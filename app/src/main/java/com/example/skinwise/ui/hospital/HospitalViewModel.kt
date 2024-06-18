package com.example.skinwise.ui.hospital

import android.util.Log
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


    fun getHospital(kota: String) {
        viewModelScope.launch {
            val result = hospitalRepository.getHospital(kota)
            Log.d("HospitalViewModel", "API result: $result")
            _hospitalResult.value = result
        }
    }


    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }
}





