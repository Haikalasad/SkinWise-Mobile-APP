package com.example.skinwise.data.model

data class loginModel(
    val token: String,
    val isLogin: Boolean,
    val name: String = "",
    val email: String = ""
)