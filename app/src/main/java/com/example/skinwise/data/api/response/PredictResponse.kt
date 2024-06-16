package com.example.skinwise.data.api.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PredictResponse(

	@field:SerializedName("data")
	val data: DataPredict,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
) : Parcelable

@Parcelize
data class DataPredict(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("link")
	val link: String,

	@field:SerializedName("step")
	val step: String,

	@field:SerializedName("class")
	val jsonMemberClass: Int
) : Parcelable
