package com.example.skinwise.data.repository

import android.util.Log
import com.example.skinwise.data.model.ChatModel
import com.example.skinwise.data.model.ListChatModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class ChatRepository {
    private val db = FirebaseFirestore.getInstance()

    suspend fun sendMessage(chatId: String, senderId: String, receiverId: String, chatMessage: ChatModel): Boolean {
        return try {
            val chatDocRef = db.collection("chats").document(chatId)

            chatDocRef.set(
                mapOf(
                    "lastMessage" to chatMessage.message,
                    "lastMessageTimestamp" to chatMessage.timestamp,
                    "user1Id" to senderId,
                    "user2Id" to receiverId,
                    "participants" to listOf(senderId, receiverId)
                ),
                SetOptions.merge()
            ).await()

            chatDocRef.collection("messages")
                .add(chatMessage)
                .await()

            true
        } catch (e: Exception) {
            Log.e("ChatRepository", "Error sending message", e)
            false
        }
    }


    fun getChatList(userId: String, onChatListUpdated: (List<ListChatModel>) -> Unit) {
        Log.d("ChatRepository", "Listening for chat list updates for user: $userId")

        try {
            db.collection("chats")
                .whereArrayContains("participants", userId)
                .addSnapshotListener { chatsQuery, error ->
                    if (error != null) {
                        Log.e("ChatRepository", "Error listening for chat list updates", error)
                        return@addSnapshotListener
                    }

                    val updatedChatList = mutableListOf<ListChatModel>()

                    chatsQuery?.documents?.forEach { chatDoc ->
                        val chatId = chatDoc.id
                        val participants = chatDoc["participants"] as List<String>

                        db.collection("chats")
                            .document(chatId)
                            .collection("messages")
                            .orderBy("timestamp", Query.Direction.DESCENDING)
                            .limit(1)
                            .get()
                            .addOnSuccessListener { messagesQuery ->
                                val lastMessageDoc = messagesQuery.documents.firstOrNull()
                                val message = lastMessageDoc?.toObject<ChatModel>()

                                if (message != null) {

                                    val isCurrentUserSender = message.senderId == userId
                                    val receiverName = if (isCurrentUserSender) {
                                        message.receiverName
                                    } else {
                                        message.senderName
                                    }
                                    val receivephotoUrl = if (isCurrentUserSender) {
                                        message.receivephotoUrl
                                    } else {
                                        message.senderphotoUrl
                                    }

                                    val chatModel = ListChatModel(
                                        chatId = chatId,
                                        user1Id = participants[0],
                                        user2Id = participants[1],
                                        lastMessage = message.message,
                                        lastMessageTimestamp = message.timestamp,
                                        participants = participants,
                                        messages = listOf(message)
                                    )
                                    updatedChatList.add(chatModel)
                                }
                            }
                    }

                    onChatListUpdated(updatedChatList)
                }
        } catch (e: Exception) {
            Log.e("ChatRepository", "Error listening for chat list updates", e)
        }
    }

}
