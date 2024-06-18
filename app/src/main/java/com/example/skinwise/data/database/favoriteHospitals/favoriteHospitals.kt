package com.example.skinwise.data.database.favoriteHospitals

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class favoriteHospitals (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "nama")
    var nama: String = "",
    @ColumnInfo(name = "image")
    var image: String? = null,
    @ColumnInfo(name = "kota")
    var kota: String = "",
    @ColumnInfo(name = "kontak")
    var kontak: String = "",
    @ColumnInfo(name = "url_lokasi")
    var url_lokasi: String = "",
    @ColumnInfo(name = "additional_info")
    var additional_info: String = "",
    @ColumnInfo(name = "dermatologist")
    var dermatologist: String = "",
    @ColumnInfo(name = "provinsi")
    var provinsi: String = "",
    @ColumnInfo(name = "alamat")
    var alamat: String = "",
    @ColumnInfo(name = "rating")
    var rating: Double? =null,
    @ColumnInfo(name = "dermatologist_avail")
    var dematologist_avail: Int?= null


) : Parcelable
