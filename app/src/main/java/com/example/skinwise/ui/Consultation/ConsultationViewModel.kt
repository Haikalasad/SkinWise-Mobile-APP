package com.example.skinwise.ui.Consultation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.model.ArticleModel
import com.example.skinwise.data.model.DoctorModel
import com.example.skinwise.data.repository.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ConsultationViewModel(private val repository: Repository) : ViewModel(){

    private val _doctors = MutableLiveData<List<DoctorModel>>()
    val doctors: LiveData<List<DoctorModel>> = _doctors

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun fetchListDoctors() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(1000)
            val doctorList = repository.getAllDoctors()
            _doctors.value = doctorList
            _isLoading.value = false
        }
    }


}