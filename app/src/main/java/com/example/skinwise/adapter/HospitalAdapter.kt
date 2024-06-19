package com.example.skinwise.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.api.response.HospitalItem
import com.example.skinwise.databinding.ItemRowHospitalBinding
import com.example.skinwise.ui.hospital.DetailHospitalActivity
import com.example.skinwise.ui.hospital.HospitalViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HospitalAdapter(private val viewModel: HospitalViewModel) :
    ListAdapter<HospitalItem, HospitalAdapter.MyViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<HospitalItem>() {
            override fun areItemsTheSame(oldItem: HospitalItem, newItem: HospitalItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HospitalItem, newItem: HospitalItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    class MyViewHolder(val binding: ItemRowHospitalBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HospitalItem, isFavorite: Boolean, viewModel: HospitalViewModel) {
            binding.tvHospitalName.text = item.nama
            binding.tvRate.text = item.rating.toString()
            binding.tvAddress.text = item.alamat
            Glide.with(binding.root).load(item.urlGambar).into(binding.imgItemPhoto)

            if (isFavorite) {
                binding.btnAddFavorite.setImageResource(R.drawable.baseline_favorite_24)
            } else {
                binding.btnAddFavorite.setImageResource(R.drawable.baseline_favorite_border_24)
            }

            binding.btnAddFavorite.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    if (isFavorite) {

                        item.nama?.let { it1 -> viewModel.deleteByName(it1) }
                        Toast.makeText(binding.root.context, "Removed from Favorites", Toast.LENGTH_SHORT).show()
                        binding.btnAddFavorite.setImageResource(R.drawable.baseline_favorite_border_24)
                    } else {

                        viewModel.addHospitalToFavorites(item)
                        Toast.makeText(binding.root.context, "Added to Favorites", Toast.LENGTH_SHORT).show()
                        binding.btnAddFavorite.setImageResource(R.drawable.baseline_favorite_24)
                    }
                }
            }

            binding.root.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, DetailHospitalActivity::class.java).apply {
                    putExtra("hospital_name", item.nama)
                    putExtra("hospital_kota", item.kota)
                    putExtra("hospital_provinsi", item.provinsi)
                    putExtra("hospital_rating", item.rating.toString())
                    putExtra("hospital_info", item.informasi)
                    putExtra("hospital_kontak", item.kontak)
                    putExtra("derma_avail", item.dermatologistAvail)
                    putExtra("hospital_image_url", item.urlGambar)
                    putExtra("hospital_location", item.urlLokasi)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemRowHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)

        CoroutineScope(Dispatchers.Main).launch {
            val isFavorite = item.nama?.let { viewModel.isHospitalFavorite(it) }
            if (isFavorite != null) {
                holder.bind(item, isFavorite, viewModel)
            }
        }
    }
}
