package com.example.skinwise.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import com.example.skinwise.data.repository.ArticleRepository
import com.example.skinwise.ui.article.ArticleActivity
import com.example.skinwise.ui.article.DetailArticleActivity
import com.example.skinwise.ui.hospital.HospitalActivity
import com.example.skinwise.ui.hospital.HospitalFragment
import com.example.skinwise.ui.main.ViewModelFactory
import com.example.skinwise.ui.hospital.HospitalViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class HomeFragment : Fragment() {

    private lateinit var userNameTextView: TextView
    private lateinit var userPhotoImageView: ImageView
    private lateinit var userPreference: UserPreference
    private lateinit var articleRepository: ArticleRepository

    // Declare view elements for displaying article
    private lateinit var articleTitleTextView: TextView
    private lateinit var articleImageView: ImageView
    private lateinit var articleCategoryTextView: TextView
    private lateinit var articleDateTextView: TextView
    private var currentArticleId by Delegates.notNull<Int>()

    // Declare buttons for categories
    private lateinit var btnRingworm: Button
    private lateinit var btnVitiligo: Button
    private lateinit var btnMelanoma: Button
    private lateinit var btnInfeksiKulit: Button

    // Declare view elements for displaying hospital
    private lateinit var hospitalTitleTextView1: TextView
    private lateinit var hospitalStreetTextView1: TextView
    private lateinit var hospitalImage1 : ImageView
    private lateinit var hospitalTitleTextView2: TextView
    private lateinit var hospitalStreetTextView2: TextView
    private lateinit var hospitalImage2 : ImageView

    private lateinit var searchView: SearchView

    // ViewModel for Hospital
    private val hospitalViewModel: HospitalViewModel by viewModels { ViewModelFactory.getInstance(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchView = view.findViewById(R.id.searchView)
        userNameTextView = view.findViewById(R.id.nameProfile)
        userPhotoImageView = view.findViewById(R.id.mainProfile)
        articleRepository = ArticleRepository()

        articleTitleTextView = view.findViewById(R.id.tittleArticle)
        articleImageView = view.findViewById(R.id.pictArticle)
        articleCategoryTextView = view.findViewById(R.id.categoryArticle)
        articleDateTextView = view.findViewById(R.id.dateArticle)


        val hintColor: Int = Color.WHITE
        val searchTextView =
            searchView.findViewById<View>(androidx.appcompat.R.id.search_src_text) as TextView
        searchTextView.setHintTextColor(hintColor)

        setTextColors(searchView, Color.WHITE)

        loadUserData()

        btnRingworm = view.findViewById(R.id.btn_ringworm)
        btnVitiligo = view.findViewById(R.id.btn_vitiligo)
        btnMelanoma = view.findViewById(R.id.btn_melanoma)
        btnInfeksiKulit = view.findViewById(R.id.btn_infeksi)

        setupCategoryButtons()

        view.findViewById<View>(R.id.textButton).setOnClickListener {
            val intent = Intent(activity, ArticleActivity::class.java)
            startActivity(intent)
        }

        view.findViewById<View>(R.id.textButton2).setOnClickListener {
            val hospitalFragment = HospitalFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, hospitalFragment)
                .addToBackStack(null)
                .commit()
        }


        view.findViewById<View>(R.id.pictArticle).setOnClickListener {
            val intent = Intent(activity, ArticleActivity::class.java)
            intent.putExtra("ARTICLE_ID", currentArticleId)
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
                return false
            }
        })

        displayArticleByCategory("Vitiligo")

        view.findViewById<View>(R.id.pictArticle).setOnClickListener {
            val intent = Intent(activity, DetailArticleActivity::class.java)
            intent.putExtra("article_id", currentArticleId)
            startActivity(intent)
        }

        // Initialize hospital views
        hospitalTitleTextView1 = view.findViewById(R.id.tittleHospital)
        hospitalStreetTextView1 = view.findViewById(R.id.streetHospital)
        hospitalImage1 = view.findViewById(R.id.hospital_image1)
        hospitalTitleTextView2 = view.findViewById(R.id.tittleHospital2)
        hospitalStreetTextView2 = view.findViewById(R.id.streetHospital2)
        hospitalImage2 = view.findViewById(R.id.hospital_image2)

        // Load hospital data
        loadHospitalData()

    }

    override fun onResume() {
        super.onResume()
        searchView.visibility = View.VISIBLE // Pastikan SearchView tetap terlihat saat kembali ke HomeFragment
    }

    private fun loadUserData() {
        userPreference = context?.let { UserPreference(it.dataStore) }
            ?: throw Exception("Invalid Activity")

        CoroutineScope(Dispatchers.Main).launch {
            val session = userPreference.getSession().first()
            userNameTextView.text = session.nama
            Glide.with(requireContext()).load(session.photoUrl)
                .placeholder(R.drawable.ic_baseline_account_circle_24)
                .error(R.drawable.ic_baseline_account_circle_24)
                .into(userPhotoImageView)
        }
    }

    private fun handleSearchQuery(query: String) {
        when {
            query.contains("penyakit", true) ||
                    query.contains("vitiligo", true) ||
                    query.contains("melanoma", true) ||
                    query.contains("mokeypox", true) ||
                    query.contains("pengobatan", true) ||
                    query.contains("tata cara", true) ||
                    query.contains("infeksi kulit", true) -> {

                val intent = Intent(activity, ArticleActivity::class.java)
                intent.putExtra("QUERY", query)
                startActivity(intent)
            }
            query.contains("rumah sakit", true) -> {
                val hospitalFragment = HospitalFragment()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, hospitalFragment)
                    .addToBackStack(null)
                    .commit()
            }
            else -> {

            }
        }
    }


    private fun setupCategoryButtons() {
        btnRingworm.setOnClickListener {
            updateCategoryButtonStyles(btnRingworm)
            displayArticleByCategory("Ringworm")
        }

        btnVitiligo.setOnClickListener {
            updateCategoryButtonStyles(btnVitiligo)
            displayArticleByCategory("Vitiligo")
        }

        btnMelanoma.setOnClickListener {
            updateCategoryButtonStyles(btnMelanoma)
            displayArticleByCategory("Melanoma")
        }

        btnInfeksiKulit.setOnClickListener {
            updateCategoryButtonStyles(btnInfeksiKulit)
            displayArticleByCategory("Infeksi Kulit")
        }
    }

    private fun updateCategoryButtonStyles(selectedButton: Button) {
        val buttons = listOf(btnRingworm, btnVitiligo, btnMelanoma, btnInfeksiKulit)
        for (button in buttons) {
            if (button == selectedButton) {
                button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blue_primary))
                button.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            } else {
                button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gray_200))
                button.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray_400))
            }
        }
    }

    private fun displayArticleByCategory(category: String) {
        val article = articleRepository.getArticleByCategory(category)
        article?.let {
            currentArticleId = it.id
            articleTitleTextView.text = it.title
            articleCategoryTextView.text = it.category
            articleDateTextView.text = it.date
            Glide.with(requireContext()).load(it.imageUrl)
                .into(articleImageView)
        }
    }

    private fun loadHospitalData() {
        hospitalViewModel.hospitalResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is com.example.skinwise.data.Result.Success -> {
                    val hospitals = result.data.data?.hospitals
                    if (hospitals != null && hospitals.size >= 2) {
                        val hospital1 = hospitals[0]
                        val hospital2 = hospitals[1]
                        hospitalTitleTextView1.text = hospital1?.nama
                        hospitalStreetTextView1.text = hospital1?.alamat
                        hospitalTitleTextView2.text = hospital2?.nama
                        hospitalStreetTextView2.text = hospital2?.alamat

                        Glide.with(requireContext()).load(hospital1?.urlGambar)
                            .into(hospitalImage1)

                        Glide.with(requireContext()).load(hospital2?.urlGambar)
                            .into(hospitalImage2)
                    }
                }
                is com.example.skinwise.data.Result.Error -> {
                    // Handle error
                }
                is com.example.skinwise.data.Result.Loading -> {
                    // Show loading indicator if necessary
                }
            }
        }

        hospitalViewModel.getHospital("Surabaya")
    }


    private fun setTextColors(searchView: SearchView, color: Int) {
        val searchTextView = searchView.findViewById<TextView>(androidx.appcompat.R.id.search_src_text)
        searchTextView.setTextColor(color)
        searchTextView.setHintTextColor(color)
    }
}
