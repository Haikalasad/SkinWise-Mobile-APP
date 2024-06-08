package com.example.skinwise.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.repository.Repository
import com.example.skinwise.data.Result
import com.example.skinwise.data.api.response.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: Repository) : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _loginResult = MutableLiveData<Result<LoginResponse>>()
    val loginResult: LiveData<Result<LoginResponse>>
        get() = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val result = repository.login(email, password)
            _loginResult.value = result

            if (result is Result.Success) {
                val token = result.data.data?.token

                if (token != null) {
                    repository.saveUserInfo(token)
                }

            }
            _isLoading.value = false
        }
    }

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }


}