package com.example.skinwise.data.database.favoriteHospitals

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.skinwise.data.database.favoriteArticle.FavoriteArticleDAO
import com.example.skinwise.data.database.favoriteArticle.FavoriteArticleRoomDatabase
import com.example.skinwise.data.database.favoriteArticle.favoriteArticle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteHospitalsRepository(application: Application) {


    private val mFavoriteHospitalDAO : FavoriteHospitalsDAO
    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init{
        val db = FavoriteHospitalsRoomDatabase.getDatabase(application)
        mFavoriteHospitalDAO = db.favoriteDao()
    }

    fun getAllFavoriteHospitals() : LiveData<List<favoriteHospitals>> = mFavoriteHospitalDAO.getAllFavoriteHospitals()

    fun insert(favorite: favoriteHospitals){
        executorService.execute { mFavoriteHospitalDAO.insert(favorite) }
    }

    fun deleteAllHospitals(favorite: favoriteHospitals){
        executorService.execute { mFavoriteHospitalDAO.deleteAllHospitals(favorite) }
    }

    fun deleteByName(nama: String) {
        executorService.execute { mFavoriteHospitalDAO.deleteByNama(nama) }
    }

    suspend fun isArticleFavorite(nama:String): Boolean {
        return withContext(Dispatchers.IO) {
            mFavoriteHospitalDAO.isFavoriteHospitals(nama)
        }
    }

}