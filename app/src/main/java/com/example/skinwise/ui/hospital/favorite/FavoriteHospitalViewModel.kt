package com.example.skinwise.ui.hospital.favorite

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.database.favoriteHospitals.FavoriteHospitalsRepository
import com.example.skinwise.data.database.favoriteHospitals.favoriteHospitals
import kotlinx.coroutines.launch

class FavoriteHospitalViewModel (
    private val application: Application,
    private val favoriteHospitalsRepository : FavoriteHospitalsRepository
)  : ViewModel(){


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    val favoriteHospitals: LiveData<List<favoriteHospitals>> = favoriteHospitalsRepository.getAllFavoriteHospitals()

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }

    fun deleteByName(name: String) {
        viewModelScope.launch {
            favoriteHospitalsRepository.deleteByName(name)
            Toast.makeText(application, "$name telah dihapus dari favorit", Toast.LENGTH_SHORT).show()
        }
    }

    fun insertFavoriteHospital(hospital:favoriteHospitals) {
        viewModelScope.launch {
            favoriteHospitalsRepository.insert(hospital)
            Toast.makeText(application, "${hospital.nama} added to favorites", Toast.LENGTH_SHORT).show()
        }
    }
}