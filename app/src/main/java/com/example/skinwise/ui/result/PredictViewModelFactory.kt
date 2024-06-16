package com.example.skinwise.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.skinwise.data.api.detection.DetectionRepository


class PredictViewModelFactory(
    private val repository: DetectionRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetectionViewModel::class.java) -> DetectionViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }

    companion object {
        @Volatile
        private var instance: PredictViewModelFactory? = null

        fun getInstance(repository: DetectionRepository): PredictViewModelFactory {
            return instance ?: synchronized(this) {
                instance ?: PredictViewModelFactory(repository)
            }.also { instance = it }
        }
    }
}
