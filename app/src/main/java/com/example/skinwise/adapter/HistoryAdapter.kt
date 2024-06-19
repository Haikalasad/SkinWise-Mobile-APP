package com.example.skinwise.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.data.database.HistoryScan.History
import com.example.skinwise.databinding.ItemRowHistoryBinding
import com.example.skinwise.ui.result.DetectionResultActivity
import com.example.skinwise.ui.result.history.HistoryViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class HistoryAdapter(
    private val viewModel: HistoryViewModel
) : ListAdapter<History, HistoryAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRowHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val history = getItem(position)

        holder.bind(history)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetectionResultActivity::class.java).apply {
                putExtra(DetectionResultActivity.HISTORY_DISEASE, history.diseaseName)
                putExtra(DetectionResultActivity.HISTORY_MEDICINE, history.medicine)
                putExtra(DetectionResultActivity.HISTORY_IMAGE, history.image)
                putExtra(DetectionResultActivity.HISTORY_DATE, history.date)
                putExtra(DetectionResultActivity.HISTORY_CONFIDENCE,history.confidence)
                putExtra(DetectionResultActivity.EXTRA_FROM_HISTORY,true)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.deleteButton.setOnClickListener {
            viewModel.delete(history)
        }
    }

    class MyViewHolder(private val binding: ItemRowHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var deleteButton: ImageButton = binding.deleteHistory
        fun bind(history: History) {
            val dateInMillis = history.date?.toLong()
            val date = dateInMillis?.let { Date(it) }
            val formattedDate = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(date)

            binding.tvItemDate.text = formattedDate

        }
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<History>() {
            override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem == newItem
            }
        }
    }
}