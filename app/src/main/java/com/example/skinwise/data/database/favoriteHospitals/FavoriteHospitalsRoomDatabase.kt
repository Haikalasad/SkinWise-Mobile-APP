package com.example.skinwise.data.database.favoriteHospitals

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [favoriteHospitals::class], version = 1)
abstract class FavoriteHospitalsRoomDatabase: RoomDatabase() {

    abstract fun favoriteDao() : FavoriteHospitalsDAO

    companion object{
        @Volatile
        private var INSTANCE : FavoriteHospitalsRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context):FavoriteHospitalsRoomDatabase{
            if (INSTANCE == null){
                synchronized(FavoriteHospitalsRoomDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        FavoriteHospitalsRoomDatabase::class.java,"favorite_article_database").build()
                }
            }
            return  INSTANCE as FavoriteHospitalsRoomDatabase
        }
    }
}