package com.example.skinwise.ui.article.favorite

import androidx.recyclerview.widget.ListAdapter
import com.example.skinwise.data.database.favoriteArticle.favoriteArticle
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.databinding.ItemRowArticleBinding
import com.example.skinwise.ui.article.DetailArticleActivity


class FavoriteArticleAdapter(private val viewModel: FavoriteArticleViewModel) : ListAdapter<favoriteArticle, FavoriteArticleAdapter.MyViewHolder>(diffCallback) {
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<favoriteArticle>() {
            override fun areItemsTheSame(oldItem: favoriteArticle, newItem: favoriteArticle): Boolean {
                return oldItem.title == newItem.title
            }
            override fun areContentsTheSame(oldItem: favoriteArticle, newItem: favoriteArticle): Boolean {
                return oldItem == newItem
            }
        }
    }

    class MyViewHolder(val binding: ItemRowArticleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: favoriteArticle) {
            binding.tvTitle.text = item.title
            binding.tvSource.text = item.category
            binding.tvDate.text = item.date
            binding.tvWriter.text = item.writer
            Glide.with(binding.root).load(item.image).into(binding.imgItemPhoto)

            val favoriteIcon  = R.drawable.baseline_bookmark_24

            binding.btnAddFavorite.setImageResource(favoriteIcon)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRowArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailArticleActivity::class.java)
            intent.putExtra("article_id", article.id)

            holder.itemView.context.startActivity(intent)
        }

        holder.binding.btnAddFavorite.setOnClickListener {
            viewModel.deleteByTitle(article.title)
        }
    }
}
