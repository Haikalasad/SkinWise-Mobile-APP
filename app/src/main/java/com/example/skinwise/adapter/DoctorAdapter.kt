package com.example.skinwise.adapter


import com.example.skinwise.ui.Consultation.ChatActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.data.model.DoctorModel
import com.example.skinwise.databinding.ItemRowDoctorBinding

class DoctorAdapter : ListAdapter<DoctorModel,DoctorAdapter.MyViewHolder>(diffCallback) {


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<DoctorModel>() {
            override fun areItemsTheSame(oldItem: DoctorModel, newItem:DoctorModel): Boolean {
                return oldItem.doctorId == newItem.doctorId
            }

            override fun areContentsTheSame(oldItem: DoctorModel, newItem: DoctorModel): Boolean {
                return oldItem == newItem
            }
        }
    }



    class MyViewHolder(val binding : ItemRowDoctorBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : DoctorModel){
            binding.tvDoctorName.text = item.name
            Glide.with(binding.root).load(item.photoUrl).into(binding.imgItemPhoto)
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
                putExtra("doctorId", item.doctorId)
            }
            context.startActivity(intent)
        }
    }


}