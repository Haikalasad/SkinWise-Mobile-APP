package com.example.skinwise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.model.ChatModel
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FirestoreChatAdapter(
    private val currentUserId: String,
    options: FirestoreRecyclerOptions<ChatModel>
) : FirestoreRecyclerAdapter<ChatModel, RecyclerView.ViewHolder>(options) {

    companion object {
        private const val VIEW_TYPE_SENT = 1
        private const val VIEW_TYPE_RECEIVED = 2
    }

    override fun getItemViewType(position: Int): Int {

        return if (getItem(position).senderId == currentUserId) VIEW_TYPE_SENT else VIEW_TYPE_RECEIVED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_SENT) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_sent, parent, false)
            SentMessageViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_received, parent, false)
            ReceivedMessageViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, model: ChatModel) {
        if (holder is SentMessageViewHolder) {
            holder.bind(model)
        } else if (holder is ReceivedMessageViewHolder) {
            holder.bind(model)
        }
    }

    inner class SentMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messengerImageView: ImageView = itemView.findViewById(R.id.ivMessenger)
        private val messengerTextView: TextView = itemView.findViewById(R.id.tvMessenger)
        private val messageTextView: TextView = itemView.findViewById(R.id.tvMessage)
        private val timestampTextView: TextView = itemView.findViewById(R.id.tvTimestamp)

        fun bind(chatMessage: ChatModel) {
            messageTextView.text = chatMessage.message
            messengerTextView.text = chatMessage.senderName

            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
            val timestampString = dateFormat.format(Date(chatMessage.timestamp))
            timestampTextView.text = timestampString

            Glide.with(itemView.context)
                .load(chatMessage.photoUrl)
                .placeholder(R.drawable.ic_baseline_account_circle_24)
                .error(R.drawable.ic_baseline_account_circle_24)
                .circleCrop()
                .into(messengerImageView)
        }
    }

    inner class ReceivedMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messengerImageView: ImageView = itemView.findViewById(R.id.ivMessenger)
        private val messengerTextView: TextView = itemView.findViewById(R.id.tvMessenger)
        private val messageTextView: TextView = itemView.findViewById(R.id.tvMessage)
        private val timestampTextView: TextView = itemView.findViewById(R.id.tvTimestamp)

        fun bind(chatMessage: ChatModel) {
            messengerTextView.text = chatMessage.senderName
            messageTextView.text = chatMessage.message

            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
            val timestampString = dateFormat.format(Date(chatMessage.timestamp))
            timestampTextView.text = timestampString

            // Load sender's photo using Glide
            Glide.with(itemView.context)
                .load(chatMessage.photoUrl)
                .placeholder(R.drawable.ic_baseline_account_circle_24)
                .error(R.drawable.ic_baseline_account_circle_24)
                .circleCrop()
                .into(messengerImageView)
        }
    }
}
