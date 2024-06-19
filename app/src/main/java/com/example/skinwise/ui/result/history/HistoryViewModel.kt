package com.example.skinwise.ui.result.history


import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.skinwise.data.database.HistoryScan.History
import com.example.skinwise.data.database.HistoryScan.HistoryRepository

class HistoryViewModel(application: Application): ViewModel(){
    private val mHistoryRepository: HistoryRepository = HistoryRepository(application)

    fun delete(history: History) {
        mHistoryRepository.delete(history)
    }

    fun getAllHistory(): LiveData<List<History>> {
        return mHistoryRepository.getAllHistory()
    }


    fun insert(history: History) {
        mHistoryRepository.insert(history)
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])

                return HistoryViewModel(
                    (application)
                ) as T
            }
        }
    }
}