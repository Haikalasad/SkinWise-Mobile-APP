package com.example.skinwise.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.model.ChatModel
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.firebase.ui.firestore.SnapshotParser
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

class FirestoreChatAdapter(
    private val currentUserEmail: String,
    options: FirestoreRecyclerOptions<ChatModel>
) : FirestoreRecyclerAdapter<ChatModel, RecyclerView.ViewHolder>(options) {

    companion object {
        private const val VIEW_TYPE_SENT = 1
        private const val VIEW_TYPE_RECEIVED = 2
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

    override fun getItemViewType(position: Int): Int {

        Log.d("ChatActivity","Sender ID :  ${getItem(position).email}")
        Log.d("ChatActivity","Curreent User ID  : $currentUserEmail")
        return if (getItem(position).email == currentUserEmail) VIEW_TYPE_SENT else VIEW_TYPE_RECEIVED


    }


    inner class SentMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messengerImageView: ImageView = itemView.findViewById(R.id.ivMessenger)
        private val messengerTextView: TextView = itemView.findViewById(R.id.tvMessenger)
        private val messageTextView: TextView = itemView.findViewById(R.id.tvMessage)
        private val timestampTextView: TextView = itemView.findViewById(R.id.tvTimestamp)

        fun bind(chatMessage: ChatModel) {
            messageTextView.text = chatMessage.message
            messengerTextView.text = chatMessage.senderName

            val timestampString = getRelativeTimeSpan(chatMessage.timestamp)
            timestampTextView.text = timestampString

            Glide.with(itemView.context)
                .load(chatMessage.senderphotoUrl)
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

            val timestampString = getRelativeTimeSpan(chatMessage.timestamp)
            timestampTextView.text = timestampString

            Glide.with(itemView.context)
                .load(chatMessage.senderphotoUrl)
                .placeholder(R.drawable.ic_baseline_account_circle_24)
                .error(R.drawable.ic_baseline_account_circle_24)
                .circleCrop()
                .into(messengerImageView)
        }
    }



    fun getRelativeTimeSpan(timestamp: Long): String {
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
