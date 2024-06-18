package com.example.skinwise.data.database.favoriteHospitals

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query



@Dao
interface FavoriteHospitalsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favorite: favoriteHospitals)

    @Delete
    fun deleteAllHospitals(favorite: favoriteHospitals)

    @Query("SELECT * from favoriteHospitals")
    fun getAllFavoriteHospitals(): LiveData<List<favoriteHospitals>>

    @Query("DELETE FROM favoriteHospitals WHERE nama = :nama")
    fun deleteByNama(nama: String)

    @Query("SELECT EXISTS (SELECT 1 FROM favoriteHospitals WHERE nama = :nama)")
    fun isFavoriteHospitals(nama: String): Boolean

}