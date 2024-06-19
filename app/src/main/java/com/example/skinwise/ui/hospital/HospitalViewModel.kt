package com.example.skinwise.ui.hospital

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skinwise.data.api.response.HospitalResponse
import com.example.skinwise.data.repository.Repository
import kotlinx.coroutines.launch
import com.example.skinwise.data.Result
import com.example.skinwise.data.api.response.HospitalItem
import com.example.skinwise.data.database.favoriteHospitals.FavoriteHospitalsRepository
import com.example.skinwise.data.database.favoriteHospitals.favoriteHospitals



class HospitalViewModel(private val hospitalRepository: Repository,private val favoriteHospitalsRepository: FavoriteHospitalsRepository) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _hospitalResult = MutableLiveData<Result<HospitalResponse>>()
    val hospitalResult: LiveData<Result<HospitalResponse>> = _hospitalResult

    val favoriteHospitals: LiveData<List<favoriteHospitals>> = favoriteHospitalsRepository.getAllFavoriteHospitals()



    fun getHospital(kota: String) {
        viewModelScope.launch {
            val result = hospitalRepository.getHospital(kota)
            Log.d("HospitalViewModel", "API result: $result")
            _hospitalResult.value = result
        }
    }


    suspend fun isHospitalFavorite(nama : String) : Boolean {
        return favoriteHospitalsRepository.isHospitalFavorite(nama)
    }

    fun deleteByName(nama: String) {
        viewModelScope.launch {
            favoriteHospitalsRepository.deleteByName(nama)
        }
    }

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }


    fun addHospitalToFavorites(item: HospitalItem) {
        viewModelScope.launch {
            try {
                val favoriteHospital = favoriteHospitals(
                    nama = item.nama ?: "",
                    kota = item.kota ?: "",
                    provinsi = item.provinsi ?: "",
                    rating = item.rating,
                    additional_info = item.informasi ?: "",
                    kontak = item.kontak ?: "",
                    url_lokasi = item.urlLokasi ?: "",
                    image = item.urlGambar ?: "",
                    dermatologist = item.dermatologist ?: "",
                    alamat = item.alamat ?:""
                )
                favoriteHospitalsRepository.insert(favoriteHospital)
            } catch (e: Exception) {
                Log.e(TAG, "Error adding hospital to favorites: ${e.message}")
            }
        }
    }
    companion object {
        private const val TAG = "HospitalViewModel"
    }

}





