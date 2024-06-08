package com.example.skinwise.ui.Consultation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skinwise.adapter.FirestoreChatAdapter
import com.example.skinwise.data.model.ChatModel
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import com.example.skinwise.data.repository.ChatRepository
import com.example.skinwise.databinding.ActivityChatBinding
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var chatAdapter: FirestoreChatAdapter
    private lateinit var userPreference: UserPreference
    private lateinit var currentUserToken: String
    private lateinit var currentUserName: String
    private lateinit var currentUserPhotoUrl: String
    private lateinit var chatRepository: ChatRepository
    private lateinit var doctorId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore = FirebaseFirestore.getInstance()
        userPreference = UserPreference.getInstance(dataStore)
        chatRepository = ChatRepository()

        // Initialize views using binding
        val recyclerView = binding.recyclerView
        val sendButton = binding.sendButton
        val messageEditText = binding.messageEditText

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Get doctorId from intent or savedInstanceState
        doctorId = intent.getStringExtra("doctorId") ?: savedInstanceState?.getString("doctorId") ?: ""

        CoroutineScope(Dispatchers.Main).launch {
            val session = userPreference.getSession().first()
            currentUserToken = session.token
            currentUserName = session.name
            currentUserPhotoUrl = session.photoUrl

            setupRecyclerView(recyclerView)
            sendButton.setOnClickListener {
                sendMessage(messageEditText.text.toString())
            }
        }
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        val query: Query = firestore.collection("chats")
            .document(doctorId)
            .collection("messages")
            .orderBy("timestamp", Query.Direction.ASCENDING)

        val options = FirestoreRecyclerOptions.Builder<ChatModel>()
            .setQuery(query, ChatModel::class.java)
            .build()

        chatAdapter = FirestoreChatAdapter(currentUserToken, options)
        recyclerView.adapter = chatAdapter
        chatAdapter.startListening()
    }

    private fun sendMessage(message: String) {
        if (message.isNotEmpty()) {
            val chatMessage = ChatModel(
                senderId = currentUserToken,
                senderName = currentUserName,
                message = message,
                timestamp = System.currentTimeMillis(),
                photoUrl = currentUserPhotoUrl
            )

            CoroutineScope(Dispatchers.IO).launch {
                val success = chatRepository.sendMessage(doctorId, chatMessage)
                withContext(Dispatchers.Main) {
                    if (success) {
                        binding.messageEditText.text.clear()
                    } else {
                        Log.e("com.example.skinwise.ui.Consultation.ChatActivity", "Error sending message")
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (::chatAdapter.isInitialized) {
            chatAdapter.startListening()
        } else {
            Log.e("com.example.skinwise.ui.Consultation.ChatActivity", "chatAdapter is not initialized yet")
        }
    }

    override fun onStop() {
        super.onStop()
        if (::chatAdapter.isInitialized) {
            chatAdapter.stopListening()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("doctorId", doctorId)
    }
}
