package com.example.skinwise.data.database.favoriteArticle

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteArticleRepository(application: Application) {


    private val mFavoriteArticleDAO : FavoriteArticleDAO
    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init{
        val db = FavoriteArticleRoomDatabase.getDatabase(application)
        mFavoriteArticleDAO = db.favoriteDao()
    }

    fun getAllFavoriteArticle() : LiveData<List<favoriteArticle>> = mFavoriteArticleDAO.getAllFavoriteArticle()

    fun insert(favorite: favoriteArticle){
        executorService.execute { mFavoriteArticleDAO.insert(favorite) }
    }

    fun deleteAllArticle(favorite: favoriteArticle){
        executorService.execute { mFavoriteArticleDAO.deleteAllArticle(favorite) }
    }

    fun deleteByTitle(title: String) {
        executorService.execute { mFavoriteArticleDAO.deleteByTitle(title) }
    }

    suspend fun isArticleFavorite(title:String): Boolean {
        return withContext(Dispatchers.IO) {
            mFavoriteArticleDAO.isFavoriteArticle(title)
        }
    }

}