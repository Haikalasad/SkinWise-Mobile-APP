package com.example.skinwise.data.database.favoriteArticle

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class favoriteArticle (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name = "image")
    var image: String? = null,
    @ColumnInfo(name = "writer")
    var writer: String = "",
    @ColumnInfo(name = "date")
    var date: String = "",
    @ColumnInfo(name = "category")
    var category: String = ""

) : Parcelable
