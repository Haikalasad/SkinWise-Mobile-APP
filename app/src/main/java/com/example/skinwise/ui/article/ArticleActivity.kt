package com.example.skinwise.ui.article

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinwise.R
import com.example.skinwise.adapter.ArticleAdapter
import com.example.skinwise.data.model.ArticleModel
import com.example.skinwise.data.database.favoriteArticle.favoriteArticle
import com.example.skinwise.databinding.ActivityArticleBinding
import com.example.skinwise.ui.article.favorite.FavoriteArticleViewModel
import com.example.skinwise.ui.article.favorite.FavoriteArticleViewModelFactory
import com.example.skinwise.ui.main.ViewModelFactory
import com.example.skinwise.data.database.favoriteArticle.FavoriteArticleRepository
import com.example.skinwise.ui.Consultation.ConsultationActivity
import com.example.skinwise.ui.hospital.HospitalActivity
import com.example.skinwise.ui.main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ArticleActivity : AppCompatActivity(), ArticleAdapter.ArticleClickListener, ArticleAdapter.FavoriteClickListener {

    private lateinit var binding: ActivityArticleBinding
    private lateinit var factory: ViewModelFactory
    private lateinit var favoriteFactory: FavoriteArticleViewModelFactory
    private val viewModel: ArticleViewModel by viewModels { factory }
    private val favoriteViewModel: FavoriteArticleViewModel by viewModels { favoriteFactory }
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var favoriteArticleRepository: FavoriteArticleRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        factory = ViewModelFactory.getInstance(this)
        favoriteArticleRepository = FavoriteArticleRepository(application)
        favoriteFactory = FavoriteArticleViewModelFactory.getInstance(application, favoriteArticleRepository)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Artikel"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val query = intent.getStringExtra("QUERY")

        val upArrow: Drawable? = ContextCompat.getDrawable(this, R.drawable.baseline_arrow_back_24)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        articleAdapter = ArticleAdapter(favoriteArticleRepository)
        binding.rvListArticle.layoutManager = LinearLayoutManager(this)
        binding.rvListArticle.adapter = articleAdapter

        viewModel.articles.observe(this) { articles ->
            articleAdapter.submitList(articles)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("ArticleActivity", "Query submitted: $query")
                query?.let { viewModel.fetchArticles(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("ArticleActivity", "Query text changed: $newText")
                newText?.let { viewModel.fetchArticles(it) }
                return false
            }
        })

        query?.let {
            binding.searchView.setQuery(it, true)
        } ?: run {
            viewModel.fetchArticles()
        }
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.action_notifications -> {
                Toast.makeText(this, "Notifikasi ditekan", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onFavoriteClicked(article: favoriteArticle) {
        val favoriteArticle = favoriteArticle(
            title = article.title,
            image = article.image,
            writer = article.writer,
            date = article.date,
            category = article.category
        )
        favoriteViewModel.insertFavoriteArticle(favoriteArticle)

        articleAdapter.updateFavoriteStatus(article.id, true)
    }

    override fun onArticleClicked(article: ArticleModel) {
        Toast.makeText(this, "Article clicked: ${article.title}", Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        val TAG = "ArticleActivity"
    }
}
