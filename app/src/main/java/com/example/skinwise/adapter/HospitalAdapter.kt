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
import com.example.skinwise.ui.hospital.DetailHospitalActivity

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

        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, DetailHospitalActivity::class.java)
            intent.putExtra("hospital_name", item.nama)
            intent.putExtra("hospital_kota", item.kota)
            intent.putExtra("hospital_provinsi",item.provinsi)
            intent.putExtra("hospital_rating", item.rating.toString())
            intent.putExtra("hospital_info",item.informasi)
            intent.putExtra("hospital_kontak",item.kontak)
            intent.putExtra("derma_avail",item.dermatologistAvail)
            intent.putExtra("hospital_image_url", item.urlGambar)
            intent.putExtra("hospital_location", item.urlLokasi)
            context.startActivity(intent)
        }
    }


}