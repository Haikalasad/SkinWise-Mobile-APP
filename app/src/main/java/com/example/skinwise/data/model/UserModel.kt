package com.example.skinwise.data.model

data class UserModel(

    val token: String,
    val isLogin: Boolean,
    val nama: String,
    val email: String,
    val photoUrl: String,
    val role: String,
    val subscriber: Boolean
)
