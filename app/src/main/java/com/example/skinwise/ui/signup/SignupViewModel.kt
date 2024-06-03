package com.example.skinwise.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.Repository
import com.example.skinwise.data.Result
import com.example.skinwise.data.api.response.RegisterResponse
import kotlinx.coroutines.launch

class SignupViewModel (private val repository: Repository) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    private val _registerResult = MutableLiveData<Result<RegisterResponse>>()
    val registerResult : LiveData<Result<RegisterResponse>>
        get() = _registerResult

    fun register(email: String, password: String, nama: String,role : String) {
        viewModelScope.launch {
            val result = repository.register(email, password, nama,role)
            _registerResult.value = result

            _isLoading.value = false
        }
    }

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }
}