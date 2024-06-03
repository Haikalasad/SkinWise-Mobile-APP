package com.example.skinwise.data.database.favoriteArticle

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [favoriteArticle::class], version = 1)
abstract class FavoriteArticleRoomDatabase : RoomDatabase() {

    abstract fun favoriteDao() : FavoriteArticleDAO

    companion object{
        @Volatile
        private var INSTANCE : FavoriteArticleRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context):FavoriteArticleRoomDatabase{
            if (INSTANCE == null){
                synchronized(FavoriteArticleRoomDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        FavoriteArticleRoomDatabase::class.java,"favorite_article_database").build()
                }
            }
            return  INSTANCE as FavoriteArticleRoomDatabase
        }
    }
}