package com.example.skinwise.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleModel(
    val id: Int,
    val category: String,
    val title: String,
    val imageUrl : String,
    val content: String,
    val author: String,
    val date: String,
    var isFavorite: Boolean = false

) : Parcelable


