package com.example.skinwise.data.database.HistoryScan

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class History(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "image")
    var image: String? = null,

    @ColumnInfo(name = "diseaseName")
    var diseaseName : String? = null,

    @ColumnInfo(name = "medicine")
    var medicine: String? = null,

    @ColumnInfo(name = "confidence")
    var confidence: Double = 0.0,


    @ColumnInfo(name= "date")
    var date: String? = null
): Parcelable

