package com.example.skinwise.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.data.api.response.HospitalItem

import com.example.skinwise.databinding.ItemRowHospitalBinding

class HospitalAdapter : ListAdapter<HospitalItem,HospitalAdapter.MyViewHolder>(diffCallback) {


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<HospitalItem>() {
            override fun areItemsTheSame(oldItem: HospitalItem, newItem:HospitalItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HospitalItem, newItem: HospitalItem): Boolean {
                return oldItem == newItem
            }
        }
    }



    class MyViewHolder(val binding : ItemRowHospitalBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : HospitalItem){
            binding.tvHospitalName.text = item.nama
            binding.tvRate.text = item.rating.toString()
            binding.tvAddress.text = item.alamat
            Glide.with(binding.root).load(item.urlGambar).into(binding.imgItemPhoto)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val binding = ItemRowHospitalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

//        holder.itemView.setOnClickListener{
//            val context = holder.itemView.context
//            val intent = Intent(contex)
//        }
    }


}