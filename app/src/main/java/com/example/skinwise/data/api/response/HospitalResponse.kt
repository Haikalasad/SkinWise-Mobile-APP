package com.example.skinwise.data.api.response

import com.google.gson.annotations.SerializedName

data class HospitalResponse(

	@field:SerializedName("data")
	val data: DataHospital? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataHospital(

	@field:SerializedName("hospitals")
	val hospitals: List<HospitalItem?>? = null
)

data class HospitalItem(

	@field:SerializedName("H_ID")
	val id: Int? = null,

	@field:SerializedName("H_kontak")
	val kontak: String? = null,

	@field:SerializedName("H_kota")
	val kota: String? = null,

	@field:SerializedName("H_url_lokasi")
	val urlLokasi: String? = null,

	@field:SerializedName("H_informasi")
	val informasi: String? = null,

	@field:SerializedName("H_nama")
	val nama: String? = null,

	@field:SerializedName("H_dermatologist")
	val dermatologist: String? = null,

	@field:SerializedName("H_provinsi")
	val provinsi: String? = null,

	@field:SerializedName("H_alamat")
	val alamat: String? = null,

	@field:SerializedName("H_url_gambar")
	val urlGambar: String? = null,

	@field:SerializedName("H_rating")
	val rating: Double? = null,

	@field:SerializedName("H_dermatologist_avail")
	val dermatologistAvail: Int? = null
)
