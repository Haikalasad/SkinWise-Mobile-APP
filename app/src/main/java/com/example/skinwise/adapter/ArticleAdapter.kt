package com.example.skinwise.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinwise.data.api.article.ArticlesItem
import com.example.skinwise.databinding.ItemRowArticleBinding
import com.google.android.material.button.MaterialButton
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class ArticleAdapter : ListAdapter<ArticlesItem, ArticleAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRowArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)

//
//        holder.itemView.setOnClickListener {
//            val context = holder.itemView.context
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra("username", item.login)
//            context.startActivity(intent)
//        }

    }

    class MyViewHolder(private val binding: ItemRowArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticlesItem) {
            with(binding){
                val originalFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
                val targetFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
                val date = article.publishedAt?.let { originalFormat.parse(it) }
                val formattedDate = date?.let { targetFormat.format(it) }

                tvTitle.text = article.title
                tvSource.text = article.source?.name
                tvDate.text = formattedDate
                tvWriter.text = article.author
                Glide.with(itemView.context).load(article.urlToImage).into(imgItemPhoto)
            }
        }
    }




    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArticlesItem>() {
            override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}