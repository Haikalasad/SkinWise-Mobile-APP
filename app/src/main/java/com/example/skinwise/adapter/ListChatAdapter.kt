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
import com.example.skinwise.data.model.ChatModel
import com.example.skinwise.ui.Consultation.ChatActivity
import java.util.concurrent.TimeUnit

class ListChatAdapter(private var chatList: MutableList<ChatModel>) :
    RecyclerView.Adapter<ListChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_list_chat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chatList[position]
        holder.bind(chat)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ChatActivity::class.java).apply {
                putExtra("doctorId", chat.receiverId)
                putExtra("doctorName", chat.receiverName)
                putExtra("doctorPhotoUrl", chat.receivephotoUrl)
                putExtra("doctorIsOnline", chat.receiverIsOnline)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        Log.d("ChatListAdapter", chatList.size.toString())
        return chatList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateChatList(newChatList: List<ChatModel>) {
        chatList.clear()
        chatList.addAll(newChatList.sortedByDescending { it.timestamp })
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val doctorNameTextView: TextView = itemView.findViewById(R.id.tv_receiver_name)
        private val timestampTextView: TextView = itemView.findViewById(R.id.tv_timestamp)
        private val messageTextView: TextView = itemView.findViewById(R.id.tv_message)
        private val imageView: ImageView = itemView.findViewById(R.id.img_item_photo)

        fun bind(chat: ChatModel) {
            doctorNameTextView.text = chat.receiverName
            timestampTextView.text = getRelativeTimeSpan(chat.timestamp)
            messageTextView.text = chat.message

            Glide.with(itemView.context).load(chat.receivephotoUrl).circleCrop().into(imageView)
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

