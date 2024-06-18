package com.example.skinwise.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.model.ListChatModel
import com.example.skinwise.ui.Consultation.ChatActivity
import java.util.concurrent.TimeUnit

class ListChatAdapter(private var chatList: List<ListChatModel>, private val currentUserUid: String) :
    RecyclerView.Adapter<ListChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_list_chat, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chatList[position]
        holder.bind(chat)
        val lastMessage = chat.messages.lastOrNull()

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ChatActivity::class.java).apply {
                putExtra("receiverId", if (currentUserUid == chat.user1Id) chat.user2Id else chat.user1Id)
                putExtra("receiverName", if (currentUserUid == chat.user1Id) lastMessage?.receiverName else lastMessage?.senderName)
                putExtra("receiverPhotoUrl", if (currentUserUid == chat.user1Id) lastMessage?.receivephotoUrl else lastMessage?.senderphotoUrl)
                putExtra("receiverIsOnline", true) // Default to false, update as necessary
                putExtra("currentUserEmail", currentUserUid)
                putExtra("senderId", currentUserUid)
            }
            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return chatList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateChatList(newChatList: List<ListChatModel>) {
        chatList = newChatList.sortedByDescending { it.messages.lastOrNull()?.timestamp ?: 0 }
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val doctorNameTextView: TextView = itemView.findViewById(R.id.tv_receiver_name)
        private val timestampTextView: TextView = itemView.findViewById(R.id.tv_timestamp)
        private val messageTextView: TextView = itemView.findViewById(R.id.tv_message)
        private val imageView: ImageView = itemView.findViewById(R.id.img_item_photo)

        fun bind(chat: ListChatModel) {
            val lastMessage = chat.messages.lastOrNull()

            val isCurrentUserSender = lastMessage?.email == currentUserUid
            val photoUrl = if (isCurrentUserSender) lastMessage?.receivephotoUrl else lastMessage?.senderphotoUrl

            Log.d("ListChatAdapter", isCurrentUserSender.toString())

            doctorNameTextView.text = if (isCurrentUserSender) {
                lastMessage?.receiverName ?: ""
            } else {
                lastMessage?.senderName ?: ""
            }

            if (photoUrl.isNullOrEmpty()) {
                imageView.setImageResource(R.drawable.baseline_person_24)
            } else {
                Glide.with(itemView.context)
                    .load(photoUrl)
                    .circleCrop()
                    .into(imageView)
            }

            timestampTextView.text = getRelativeTimeSpan(lastMessage?.timestamp ?: 0L)
            messageTextView.text = lastMessage?.message ?: ""
        }

    }

    private fun getRelativeTimeSpan(timestamp: Long): String {
        val now = System.currentTimeMillis()
        val diff = now - timestamp

        val seconds = TimeUnit.MILLISECONDS.toSeconds(diff)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(diff)
        val hours = TimeUnit.MILLISECONDS.toHours(diff)
        val days = TimeUnit.MILLISECONDS.toDays(diff)

        return when {
            seconds < 60 -> "just now"
            minutes < 60 -> "$minutes minutes ago"
            hours < 24 -> "$hours hours ago"
            else -> "$days days ago"
        }
    }
}
