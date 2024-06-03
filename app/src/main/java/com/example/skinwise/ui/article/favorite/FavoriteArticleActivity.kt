package com.example.skinwise.ui.article.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinwise.R
import com.example.skinwise.data.database.favoriteArticle.FavoriteArticleRepository
import com.example.skinwise.databinding.ActivityFavoriteArticleBinding

class FavoriteArticleActivity : AppCompatActivity() {

    private lateinit var binding  : ActivityFavoriteArticleBinding
    private lateinit var adapter: FavoriteArticleAdapter
    private lateinit var favoriteFactory: FavoriteArticleViewModelFactory
    private val viewModel :FavoriteArticleViewModel by viewModels { favoriteFactory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter = FavoriteArticleAdapter(viewModel)
        binding.rvListFavorite.layoutManager = LinearLayoutManager(this)
        binding.rvListFavorite.adapter = adapter
        viewModel.setLoading(true)

        viewModel.favoriteArticles.observe(this){ articles ->
            Handler().postDelayed({
                viewModel.setLoading(false)
                adapter.submitList(articles)
            },1500)

        }

        viewModel.isLoading.observe(this){
            isLoading -> showLoading(isLoading)
        }
    }

    private fun showLoading(state: Boolean) { binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE }
}