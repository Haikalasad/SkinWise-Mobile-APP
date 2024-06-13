package com.example.skinwise.ui.Consultation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.api.response.DoctorResponse
import com.example.skinwise.data.model.ChatModel
import com.example.skinwise.data.repository.ChatRepository
import com.example.skinwise.data.repository.Repository
import com.example.skinwise.data.Result
import com.example.skinwise.data.model.ListChatModel
import kotlinx.coroutines.launch

class ConsultationViewModel(private val repository: Repository) : ViewModel(){

    private val _doctorsResult = MutableLiveData<Result<DoctorResponse>>()
    val doctorsResult: LiveData<Result<DoctorResponse>>
        get() = _doctorsResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val chatRepository = ChatRepository()
    private val _chatList = MutableLiveData<List<ListChatModel>>()
    val chatList: LiveData<List<ListChatModel>>
        get() = _chatList


    fun getAllDoctors(){
        viewModelScope.launch{
            val result = repository.getDoctors()
            _doctorsResult.value = result
            _isLoading.value = false

        }
    }

    fun fetchChatList(userEmail: String) {
        viewModelScope.launch {
            chatRepository.getChatList(userEmail) { updatedChatList ->
                _chatList.postValue(updatedChatList)
            }
        }
    }
}