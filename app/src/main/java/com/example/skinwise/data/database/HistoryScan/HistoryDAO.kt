package com.example.skinwise.data.database.HistoryScan


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface HistoryDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(history: History)

    @Update
    fun update(history: History)

    @Delete
    fun delete(history: History)

    @Query("SELECT * from history ORDER BY id ASC")
    fun getAllHistory(): LiveData<List<History>>


    @Query("SELECT * FROM history ORDER BY date DESC LIMIT 1")
    fun getRecentHistory(): LiveData<List<History>>
}