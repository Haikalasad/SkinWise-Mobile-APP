package com.example.skinwise.data.database.favoriteArticle

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface FavoriteArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favorite: favoriteArticle)

    @Delete
    fun deleteAllArticle(favorite: favoriteArticle)

    @Query("SELECT * from favoriteArticle")
    fun getAllFavoriteArticle(): LiveData<List<favoriteArticle>>

    @Query("DELETE FROM favoriteArticle WHERE title = :title")
    fun deleteByTitle(title: String)

    @Query("SELECT EXISTS (SELECT 1 FROM favoriteArticle WHERE title = :title)")
    fun isFavoriteArticle(title: String): Boolean

}