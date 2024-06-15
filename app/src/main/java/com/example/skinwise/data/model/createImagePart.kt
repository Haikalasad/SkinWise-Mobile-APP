package com.example.skinwise.data.model

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

fun createImagePart(filePath: String, partName: String = "image"): MultipartBody.Part {
    val file = File(filePath)
    val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), file)
    return MultipartBody.Part.createFormData(partName, file.name, requestFile)
}