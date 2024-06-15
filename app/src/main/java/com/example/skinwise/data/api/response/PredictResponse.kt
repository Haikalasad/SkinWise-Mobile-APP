package com.example.skinwise.data.api.response

import com.google.gson.annotations.SerializedName

data class PredictResponse(

	@field:SerializedName("data")
	val data: DataPredict,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class DataPredict(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("link")
	val link: String,

	@field:SerializedName("step")
	val step: String,

	@field:SerializedName("class")
	val jsonMemberClass: Int
)
