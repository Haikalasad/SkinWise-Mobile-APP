package com.example.skinwise.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HospitalFavoriteModel(
    val province: String,
    val city: String,
    val hospitalName : String,
    val contact : String,
    val imageUrl : String,
    val address: String,
    val locationUrl: String,
    val additionalInfo: String,
    val rating : Double,


) : Parcelable


