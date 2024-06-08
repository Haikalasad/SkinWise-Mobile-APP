package com.example.skinwise.data.repository

import android.util.Log
import com.example.skinwise.data.model.ChatModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ChatRepository {
    private val db = FirebaseFirestore.getInstance()

    suspend fun sendMessage(doctorId: String, chatMessage: ChatModel): Boolean {
        return try {
            db.collection("chats")
                .document(doctorId)
                .collection("messages")
                .add(chatMessage)
                .await()
            true
        } catch (e: Exception) {
            Log.e("ChatRepository", "Error sending message", e)
            false
        }
    }

    fun getMessages(doctorId: String, onResult: (List<ChatModel>) -> Unit) {
        db.collection("chats")
            .document(doctorId)
            .collection("messages")
            .orderBy("timestamp")
            .addSnapshotListener { snapshot, e ->
                if (e != null || snapshot == null) {
                    Log.e("ChatRepository", "Error getting messages", e)
                    onResult(emptyList())
                    return@addSnapshotListener
                }

                val messages = snapshot.toObjects(ChatModel::class.java)
                onResult(messages)
            }
    }
}
