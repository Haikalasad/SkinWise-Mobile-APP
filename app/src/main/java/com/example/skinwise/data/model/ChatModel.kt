package com.example.skinwise.data.model

data class ChatModel(
    val senderId: String = "",
    val senderName: String = "",
    val message: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val photoUrl: String = ""
)
