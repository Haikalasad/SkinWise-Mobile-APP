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
import com.example.skinwise.data.model.ArticleModel
import com.example.skinwise.data.database.favoriteArticle.FavoriteArticleRepository
import com.example.skinwise.data.database.favoriteArticle.favoriteArticle
import com.example.skinwise.databinding.ItemRowArticleBinding
import com.example.skinwise.ui.article.DetailArticleActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ArticleAdapter(
    private val favoriteArticleRepository: FavoriteArticleRepository
) : ListAdapter<ArticleModel, ArticleAdapter.ArticleViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<ArticleModel>() {
        override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemRowArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
    }

    inner class ArticleViewHolder(private val binding: ItemRowArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val coroutineScope = CoroutineScope(Dispatchers.Main)
        fun bind(article: ArticleModel) {
            with(binding) {
                tvSource.text = article.category
                tvTitle.text = article.title
                tvWriter.text = article.author
                tvDate.text = article.date
                Glide.with(itemView)
                    .load(article.imageUrl)
                    .centerCrop()
                    .into(imgItemPhoto)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailArticleActivity::class.java)
                    intent.putExtra("article_id", article.id)
                    itemView.context.startActivity(intent)
                }

                coroutineScope.launch {
                    val isFavorite = favoriteArticleRepository.isArticleFavorite(article.title)
                    val favoriteIcon = if (isFavorite) R.drawable.baseline_bookmark_24 else R.drawable.baseline_bookmark_border_24
                    btnAddFavorite.setImageResource(favoriteIcon)
                }


                btnAddFavorite.setOnClickListener {
                    val favoriteArticle = favoriteArticle(
                        title = article.title,
                        image = article.imageUrl,
                        writer = article.author,
                        date = article.date,
                        category = article.category
                    )

                    article.isFavorite = !article.isFavorite

                    val updatedFavoriteIcon = if (article.isFavorite) R.drawable.baseline_bookmark_24 else R.drawable.baseline_bookmark_border_24
                    btnAddFavorite.setImageResource(updatedFavoriteIcon)

                    coroutineScope.launch {
                        if (article.isFavorite) {
                            favoriteArticleRepository.insert(favoriteArticle)
                            Toast.makeText(itemView.context, "${article.title} berhasil ditambahkan ke favorite", Toast.LENGTH_SHORT).show()
                        } else {
                            favoriteArticleRepository.deleteByTitle(article.title)
                            Toast.makeText(itemView.context, "${article.title} berhasil dihapus dari favorite", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    interface ArticleClickListener {
        fun onArticleClicked(article: ArticleModel)
    }

    interface FavoriteClickListener {
        fun onFavoriteClicked(article: favoriteArticle)
    }


    fun updateFavoriteStatus(articleId: Int, isFavorite: Boolean) {
        val position = currentList.indexOfFirst { it.id == articleId }
        if (position != RecyclerView.NO_POSITION) {
            val currentListMutable = currentList.toMutableList()
            currentListMutable[position].isFavorite = isFavorite
            submitList(currentListMutable)
        }
    }

}



//class ArticleAdapter : ListAdapter<ArticlesItem, ArticleAdapter.MyViewHolder>(DIFF_CALLBACK) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val binding = ItemRowArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MyViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val article = getItem(position)
//        holder.bind(article)
//
////
////        holder.itemView.setOnClickListener {
////            val context = holder.itemView.context
////            val intent = Intent(context, DetailActivity::class.java)
////            intent.putExtra("username", item.login)
////            context.startActivity(intent)
////        }
//
//    }
//
//    class MyViewHolder(private val binding: ItemRowArticleBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(article: ArticlesItem) {
//            with(binding){
//                val originalFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
//                val targetFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
//                val date = article.publishedAt?.let { originalFormat.parse(it) }
//                val formattedDate = date?.let { targetFormat.format(it) }
//
//                tvTitle.text = article.title
//                tvSource.text = article.source?.name
//                tvDate.text = formattedDate
//                tvWriter.text = article.author
//                Glide.with(itemView.context).load(article.urlToImage).into(imgItemPhoto)
//            }
//        }
//    }
//
//
//
//
//    companion object {
//        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArticlesItem>() {
//            override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
//                return oldItem == newItem
//            }
//
//            override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//}