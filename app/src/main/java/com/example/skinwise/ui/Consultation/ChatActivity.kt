package com.example.skinwise.ui.Consultation

import android.os.Bundle
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.adapter.FirestoreChatAdapter
import com.example.skinwise.data.model.ChatModel
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import com.example.skinwise.data.repository.ChatRepository
import com.example.skinwise.databinding.ActivityChatBinding
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first
import org.json.JSONObject

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var chatAdapter: FirestoreChatAdapter
    private lateinit var userPreference: UserPreference
    private lateinit var currentUserEmail: String
    private lateinit var currentUserToken: String
    private lateinit var currentUserName: String
    private lateinit var currentUserPhotoUrl: String
    private lateinit var chatRepository: ChatRepository
    private lateinit var receiverId: String
    private lateinit var receiverEmail: String
    private lateinit var receiverName: String
    private lateinit var receiverPhotoUrl: String
    private var receiverIsOnline: Boolean = false
    private lateinit var chatId: String
    private var isDoctor: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        firestore = FirebaseFirestore.getInstance()
        userPreference = UserPreference.getInstance(dataStore)
        chatRepository = ChatRepository()

        receiverId = intent.getStringExtra("receiverId") ?: ""
        receiverName = intent.getStringExtra("receiverName") ?: ""
        receiverEmail = receiverId // Assuming receiverId is the email
        receiverPhotoUrl = intent.getStringExtra("receiverPhotoUrl") ?: ""
        receiverIsOnline = intent.getBooleanExtra("receiverIsOnline", true)

        CoroutineScope(Dispatchers.Main).launch {
            initializeUserDetails()
            setupRecyclerView(recyclerView)
            binding.sendButton.setOnClickListener {
                sendMessage(binding.messageEditText.text.toString())
            }
        }

        setupDoctorStatus()

        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }
    }

    private suspend fun initializeUserDetails() {
        val session = withContext(Dispatchers.IO) {
            userPreference.getSession().first()
        }
        currentUserToken = session.token
        currentUserEmail = session.email
        currentUserName = session.nama
        currentUserPhotoUrl = session.photoUrl

        isDoctor = session.role == "doctor"

        chatId = generateChatId(currentUserEmail, receiverEmail)
    }

    private fun generateChatId(userId: String, doctorId: String): String {
        return if (userId < doctorId) {
            "$userId$doctorId"
        } else {
            "$doctorId$userId"
        }
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        val query: Query = firestore.collection("chats")
            .document(chatId)
            .collection("messages")
            .orderBy("timestamp", Query.Direction.ASCENDING)

        val options = FirestoreRecyclerOptions.Builder<ChatModel>()
            .setQuery(query, ChatModel::class.java)
            .build()

        chatAdapter = FirestoreChatAdapter(currentUserEmail, options)

        recyclerView.adapter = chatAdapter
        chatAdapter.startListening()
    }

    private fun setupDoctorStatus() {
        binding.doctorNameTextView.text = receiverName
        binding.doctorStatusTextView.text = if (receiverIsOnline) "Online" else "Offline"
        val statusColor = if (receiverIsOnline) R.color.green else R.color.gray_disabled
        binding.onlineStatusImageView.setColorFilter(resources.getColor(statusColor, null))

        Glide.with(this)
            .load(receiverPhotoUrl)
            .placeholder(R.drawable.ic_baseline_account_circle_24)
            .error(R.drawable.ic_baseline_account_circle_24)
            .circleCrop()
            .into(binding.doctorProfileImageView)
    }

    private fun sendMessage(message: String) {
        if (message.isNotEmpty()) {
            val chatMessage = ChatModel(
                senderId = currentUserToken,
                email = currentUserEmail,
                receiverId = receiverEmail,
                senderName = currentUserName,
                message = message,
                timestamp = System.currentTimeMillis(),
                receivephotoUrl = receiverPhotoUrl,
                senderphotoUrl = currentUserPhotoUrl,
                receiverName = receiverName
            )

            CoroutineScope(Dispatchers.IO).launch {
                val success = chatRepository.sendMessage(chatId, currentUserEmail, receiverEmail, chatMessage)
                withContext(Dispatchers.Main) {
                    if (success) {
                        binding.messageEditText.text.clear()
                        sendNotificationToRecipient(receiverId, message)
                    } else {
                        Log.e("ChatActivity", "Error sending message")
                    }
                }
            }
        }
    }

    private fun sendNotificationToRecipient(receiverId: String, message: String) {
        FirebaseFirestore.getInstance().collection("users").document(receiverId).get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val token = document.getString("fcmToken")
                    if (!token.isNullOrEmpty()) {
                        val notification = JSONObject()
                        val notificationBody = JSONObject()

                        try {
                            notificationBody.put("title", "New Message from $currentUserName")
                            notificationBody.put("message", message)
                            notification.put("to", token)
                            notification.put("data", notificationBody)
                        } catch (e: Exception) {
                            Log.e("ChatActivity", "onCreate: " + e.message)
                        }

                        sendNotification(notification)
                    }
                }
            }
    }

    private fun sendNotification(notification: JSONObject) {
        val jsonObjectRequest = object : JsonObjectRequest(
            Method.POST, "https://fcm.googleapis.com/fcm/send",
            notification,
            { response ->
                Log.i("ChatActivity", "onResponse: $response")
            },
            { error ->
                Log.i("ChatActivity", "onErrorResponse: Didn't work")
            }) {
            override fun getHeaders(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["Authorization"] = "AIzaSyA11Y_Nh2hOhkw13INjetr82P-JXq9A7kY"
                params["Content-Type"] = "application/json"
                return params
            }
        }
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }

    override fun onStart() {
        super.onStart()
        if (::chatAdapter.isInitialized) {
            chatAdapter.startListening()
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
        outState.putString("receiverId", receiverId)
    }
}
