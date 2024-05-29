package com.example.skinwise.ui.article

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityDetailArticleBinding
import com.example.skinwise.ui.main.ViewModelFactory

class DetailArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailArticleBinding
    private lateinit var viewModel: ArticleViewModel
    private var articleId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val uri = Uri.parse("https://www.halodoc.com/artikel")

        binding.floatingButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)

        }


        articleId = intent.getIntExtra("article_id", 0)

        val factory = ViewModelFactory.getInstance(application)
        viewModel = ViewModelProvider(this, factory)[ArticleViewModel::class.java]

        val article = viewModel.getArticleById(articleId)

        article?.let {
            binding.tvDateArticle.text = it.date
            binding.tvCategoryArticle.text = it.category
            binding.tvTitleArticle.text= it.title
            binding.tvDeskripsiArticle.text = it.content

            Glide.with(this)
                .load(it.imageUrl)
                .into(binding.pictArticle)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.info_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.action_faq -> {
                Toast.makeText(this, "FAQ clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
