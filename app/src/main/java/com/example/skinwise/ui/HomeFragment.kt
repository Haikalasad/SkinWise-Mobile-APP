package com.example.skinwise.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.skinwise.R
import com.example.skinwise.ui.article.ArticleActivity
import com.example.skinwise.ui.hospital.HospitalActivity
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchBar = view.findViewById<View>(R.id.searchBar)
        val searchView = view.findViewById<SearchView>(R.id.searchView)
        val textButton = view.findViewById<View>(R.id.textButton)
        val textButton2 = view.findViewById<View>(R.id.textButton2)
        val pictArticle = view.findViewById<View>(R.id.pictArticle)

        textButton.setOnClickListener {
            val intent = Intent(activity, ArticleActivity::class.java)
            startActivity(intent)
        }

        pictArticle.setOnClickListener {
            val intent = Intent(activity, ArticleActivity::class.java)
            startActivity(intent)
        }

        textButton2.setOnClickListener {
            val intent = Intent(activity, HospitalActivity::class.java)
            startActivity(intent)
        }
        // Configure search bar and search view
        searchBar.setOnClickListener {
            searchView.visibility = View.VISIBLE
            searchView.requestFocus()
        }

        searchView.setOnCloseListener {
            searchView.visibility = View.GONE
            false
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                handleSearchQuery(query)
                searchView.visibility = View.GONE
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Optional: handle text change if needed
                return false
            }
        })
    }
    private fun handleSearchQuery(query: String) {
        // This function will handle the search logic
        // For example, you can start a new activity with the search results

        // Check if query is for articles or hospitals
        if (query.contains("article_keyword", true)) {
            val intent = Intent(activity, ArticleActivity::class.java)
            intent.putExtra("QUERY", query)
            startActivity(intent)
        } else if (query.contains("hospital_keyword", true)) {
            val intent = Intent(activity, HospitalActivity::class.java)
            intent.putExtra("QUERY", query)
            startActivity(intent)
        } else {
            // Handle cases where query doesn't match known categories
            // You can either show a message or handle it in another way
        }
    }
}