package com.example.skinwise.data.repository

import android.util.Log
import com.example.skinwise.data.model.ChatModel
import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await

class ChatRepository {
    private val db = FirebaseFirestore.getInstance()

    suspend fun sendMessage(senderId: String, receiverId: String, chatMessage: ChatModel): Boolean {
        return try {

            db.collection("chats")
                .document(senderId)
                .collection("doctors")
                .document(receiverId)
                .set(mapOf("doctorId" to receiverId))
                .await()

            db.collection("chats")
                .document(senderId)
                .collection("doctors")
                .document(receiverId)
                .collection("messages")
                .add(chatMessage)
                .await()

            true
        } catch (e: Exception) {
            Log.e("ChatRepository", "Error sending message", e)
            false
        }
    }

    fun getChatList(userEmail: String, onChatListUpdated: (List<ChatModel>) -> Unit) {
        Log.d("ChatRepository", "Listening for chat list updates for user: $userEmail")

        try {
            db.collection("chats")
                .document(userEmail)
                .collection("doctors")
                .addSnapshotListener { doctorsQuery, error ->
                    if (error != null) {
                        Log.e("ChatRepository", "Error listening for chat list updates", error)
                        return@addSnapshotListener
                    }

                    val updatedChatList = mutableListOf<ChatModel>()

                    val tasks = doctorsQuery?.documents?.map { doctorDoc ->
                        val doctorId = doctorDoc.id

                        db.collection("chats")
                            .document(userEmail)
                            .collection("doctors")
                            .document(doctorId)
                            .collection("messages")
                            .orderBy("timestamp", Query.Direction.DESCENDING)
                            .limit(1)
                            .get()
                            .continueWith { messagesQuery ->
                                if (messagesQuery.isSuccessful) {
                                    val lastMessageDoc = messagesQuery.result.documents.firstOrNull()
                                    val message = lastMessageDoc?.toObject(ChatModel::class.java)
                                    message?.let { updatedChatList.add(it) }
                                }
                            }
                    } ?: emptyList()

                    Tasks.whenAllComplete(tasks).addOnCompleteListener {
                        onChatListUpdated(updatedChatList)
                    }
                }
        } catch (e: Exception) {
            Log.e("ChatRepository", "Error listening for chat list updates", e)
        }
    }
}
