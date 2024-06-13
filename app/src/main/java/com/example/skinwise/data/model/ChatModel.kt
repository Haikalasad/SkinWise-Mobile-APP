package com.example.skinwise.data.model

data class ChatModel(
    val senderId: String = "",
    val email: String = "",
    val receiverId: String = "",
    val receiverName: String = "",
    val senderName: String = "",
    val message: String = "",
    val timestamp: Long = 0L,
    val senderphotoUrl: String = "",
    val receivephotoUrl: String = "",
    val senderIsOnline: Boolean = true,
    val receiverIsOnline: Boolean = true,
    val fcmToken : String = ""
) {
    // Default no-argument constructor required by Firestore
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
        receiverIsOnline = true,
        fcmToken = ""
    )
}

data class ListChatModel(
    val chatId: String = "", // Document ID of the chat
    val user1Id: String = "", // ID pengguna 1
    val user2Id: String = "", // ID pengguna 2
    val lastMessage: String = "", // Pesan terakhir
    val lastMessageTimestamp: Long = 0L, // Timestamp pesan terakhir
    val participants: List<String> = emptyList(), // Daftar partisipan
    val messages: List<ChatModel> = emptyList() // Daftar pesan dalam chat
)
