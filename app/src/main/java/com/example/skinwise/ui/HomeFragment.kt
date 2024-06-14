package com.example.skinwise.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import com.example.skinwise.ui.article.ArticleActivity
import com.example.skinwise.ui.hospital.HospitalActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var userNameTextView: TextView
    private lateinit var userPhotoImageView: ImageView
    private lateinit var userPreference: UserPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchView = view.findViewById<SearchView>(R.id.searchView)

        userNameTextView = view.findViewById(R.id.nameProfile)
        userPhotoImageView = view.findViewById(R.id.mainProfile)

        val hintColor: Int = Color.WHITE
        val searchTextView =
            searchView.findViewById<View>(androidx.appcompat.R.id.search_src_text) as TextView
        searchTextView.setHintTextColor(hintColor)

        loadUserData()

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
        searchView.setOnClickListener {
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


    private fun loadUserData() {
        userPreference = context?.let { UserPreference(it.dataStore) }
            ?: throw Exception("Invalid Activity")

        CoroutineScope(Dispatchers.Main).launch {
            val session = userPreference.getSession().first()
            userNameTextView.text = session.nama
            Glide.with(requireContext()).load(session.photoUrl).placeholder(R.drawable.ic_baseline_account_circle_24) // Placeholder if image loading fails
                .error(R.drawable.ic_baseline_account_circle_24).into(userPhotoImageView)
        }

    }

    private fun handleSearchQuery(query: String) {

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
