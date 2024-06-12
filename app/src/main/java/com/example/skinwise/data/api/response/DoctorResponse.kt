package com.example.skinwise.data.api.response

import com.google.gson.annotations.SerializedName

data class DoctorResponse(

	@field:SerializedName("data")
	val data: DataDoctor? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataDoctor(

	@field:SerializedName("doctors")
	val doctors: List<DoctorsItem?>? = null
)

data class DoctorsItem(

	@field:SerializedName("U_email")
	val uEmail: String? = null,

	@field:SerializedName("U_nama")
	val uNama: String? = null,

	@field:SerializedName("U_role")
	val uRole: String? = null,

	@field:SerializedName("U_ID")
	val uID: String? = null,

	val isLogin: Boolean = true,
)
