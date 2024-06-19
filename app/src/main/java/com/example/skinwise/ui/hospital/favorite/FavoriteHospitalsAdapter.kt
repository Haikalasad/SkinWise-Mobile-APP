package com.example.skinwise.ui.hospital.favorite

import androidx.recyclerview.widget.ListAdapter
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.database.favoriteHospitals.favoriteHospitals
import com.example.skinwise.databinding.ItemRowHospitalBinding
import com.example.skinwise.ui.article.DetailArticleActivity
import com.example.skinwise.ui.hospital.DetailHospitalActivity
import com.example.skinwise.ui.hospital.HospitalViewModel


class FavoriteHospitalsAdapter(private val viewModel: HospitalViewModel) : ListAdapter<favoriteHospitals, FavoriteHospitalsAdapter.MyViewHolder>(diffCallback) {
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<favoriteHospitals>() {
            override fun areItemsTheSame(oldItem: favoriteHospitals, newItem: favoriteHospitals): Boolean {
                return oldItem.nama == newItem.nama
            }
            override fun areContentsTheSame(oldItem: favoriteHospitals, newItem: favoriteHospitals): Boolean {
                return oldItem == newItem
            }
        }
    }

    class MyViewHolder(val binding: ItemRowHospitalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: favoriteHospitals) {
            binding.tvHospitalName.text = item.nama
            binding.tvAddress.text = item.alamat
            binding.tvRate.text = item.rating.toString()
            Glide.with(binding.root).load(item.image).into(binding.imgItemPhoto)

            val favoriteIcon  = R.drawable.baseline_favorite_24

            binding.btnAddFavorite.setImageResource(favoriteIcon)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRowHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hospitals = getItem(position)
        holder.bind(hospitals)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailHospitalActivity::class.java)
            intent.putExtra("hospitals name", hospitals.nama)

            holder.itemView.context.startActivity(intent)
        }

        holder.binding.btnAddFavorite.setOnClickListener {
            viewModel.deleteByName(hospitals.nama)
        }
    }
}
