package com.example.skinwise.data.model

data class ChatModel(
    val senderId: String = "",
    val email : String= "",
    val receiverId: String = "",
    val receiverName: String,
    val senderName: String = "",
    val message: String = "",
    val timestamp: Long = 0L,
    val senderphotoUrl: String = "",
    val receivephotoUrl: String = "",
    val senderIsOnline: Boolean = true,
    val receiverIsOnline: Boolean = true,
) {

    constructor() : this(
        senderId = "",
        email = "",
        receiverId = "",
        receiverName = "",
        senderName = "",
        message = "",
        timestamp = 0L,
        senderphotoUrl = "",
        receivephotoUrl = "",
        senderIsOnline = true,
        receiverIsOnline = true
    )
}
