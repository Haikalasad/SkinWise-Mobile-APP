package com.example.skinwise.adapter


import com.example.skinwise.ui.Consultation.ChatActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.data.api.response.DoctorsItem
import com.example.skinwise.databinding.ItemRowDoctorBinding

class DoctorAdapter : ListAdapter<DoctorsItem,DoctorAdapter.MyViewHolder>(diffCallback) {


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<DoctorsItem>() {
            override fun areItemsTheSame(oldItem: DoctorsItem, newItem:DoctorsItem): Boolean {
                return oldItem.uID == newItem.uID
            }

            override fun areContentsTheSame(oldItem: DoctorsItem, newItem: DoctorsItem): Boolean {
                return oldItem == newItem
            }
        }
    }



    class MyViewHolder(val binding : ItemRowDoctorBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : DoctorsItem){
            binding.tvDoctorName.text = item.uNama
            Glide.with(binding.root).load(item.uFoto).into(binding.imgItemPhoto)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val binding = ItemRowDoctorBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)



        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ChatActivity::class.java).apply {
                putExtra("receiverId", item.uEmail)
                putExtra("receiverName", item.uNama)
                putExtra("receiverPhotoUrl", item.uFoto)
                putExtra("receiverIsOnline", item.isOnline)
                putExtra("receiverEmail",item.uEmail)
            }
            context.startActivity(intent)
        }
    }


}