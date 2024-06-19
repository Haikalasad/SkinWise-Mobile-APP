package com.example.skinwise.data.database.HistoryScan

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class HistoryRepository(application: Application) {
    private val mHistoryDao: HistoryDAO
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()
    val recentHistory: LiveData<List<History>>

    init {
        val db = HistoryRoomDatabase.getDatabase(application)
        mHistoryDao = db.historyDao()
        recentHistory = mHistoryDao.getRecentHistory()
    }

    fun getAllHistory(): LiveData<List<History>> = mHistoryDao.getAllHistory()

    fun insert(history: History){
        executorService.execute { mHistoryDao.insert(history) }
    }

    fun delete(history: History){
        executorService.execute { mHistoryDao.delete(history) }
    }

}