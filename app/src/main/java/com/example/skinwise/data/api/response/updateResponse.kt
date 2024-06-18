package com.example.skinwise.data.api.response

import com.google.gson.annotations.SerializedName

data class updateResponse(

    @field:SerializedName("status")
    val status : String? = null,

    @field:SerializedName("message")
    val message: String? = null,

)
