package com.example.skinwise.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.adapter.ListChatAdapter
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import com.example.skinwise.ui.article.ArticleActivity
import com.example.skinwise.ui.article.favorite.FavoriteArticleActivity
import com.example.skinwise.ui.login.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    private lateinit var userNameTextView: TextView
    private lateinit var userPhotoImageView: ImageView
    private lateinit var userPreference: UserPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logoutButton = view.findViewById<View>(R.id.filledTonalButton)
        val articleFav  = view.findViewById<View>(R.id.nextarticlefav)

        userNameTextView = view.findViewById(R.id.nameProfile)
        userPhotoImageView = view.findViewById(R.id.mainProfile)

        logoutButton.setOnClickListener {
            showLogoutConfirmationDialog()
        }

        articleFav.setOnClickListener {
            val intent = Intent(activity, FavoriteArticleActivity::class.java)
            startActivity(intent)
        }

        loadUserData()
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
    private fun showLogoutConfirmationDialog() {
        AlertDialog.Builder(requireContext()).apply {
            setTitle(getString(R.string.confirmExit))
            setMessage(getString(R.string.exit))
            setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                dialog.dismiss()
                logout()
            }
            setNegativeButton(getString(R.string.no)) { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(
                    requireContext(),
                    getString(R.string.stayLoggedIn),
                    Toast.LENGTH_SHORT
                ).show()
            }
            create()
            show()
        }
    }

    private fun logout() {
        // Clear session or any stored user data
        val sharedPref = activity?.getSharedPreferences("session", Context.MODE_PRIVATE)
        sharedPref?.edit()?.clear()?.apply()

        // Navigate to login screen
        val intent = Intent(activity, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        activity?.finish()
    }
}
