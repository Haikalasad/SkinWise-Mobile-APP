package com.example.skinwise.ui.article

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinwise.R
import com.example.skinwise.adapter.ArticleAdapter
import com.example.skinwise.data.Result
import com.example.skinwise.databinding.ActivityArticleBinding
import com.example.skinwise.ui.ViewModelFactory

class ArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleBinding
    private lateinit var factory: ViewModelFactory
    private val viewModel: ArticleViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar :Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.article)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow: Drawable? = ContextCompat.getDrawable(this, R.drawable.baseline_arrow_back_24)
        supportActionBar?.setHomeAsUpIndicator(upArrow)


        val articleAdapter = ArticleAdapter()
        factory = ViewModelFactory.getInstance(this)

        val layoutManager = LinearLayoutManager(this)
        binding.rvListArticle.layoutManager = layoutManager
        binding.rvListArticle.adapter = articleAdapter

        viewModel.articles.observe(this, Observer { result ->
            if (result is Result.Success) {
                articleAdapter.submitList(result.data.articles)
            } else {
                Toast.makeText(this, "Fetch Artikel Gagal", Toast.LENGTH_SHORT).show()
            }
        })

        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.fetchArticles(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (it.isEmpty()) {

                        viewModel.fetchArticles("skin diseases")
                    } else {
                        viewModel.fetchArticles(it)
                    }
                }

                return true
            }
        })


        viewModel.fetchArticles("skin diseases")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
