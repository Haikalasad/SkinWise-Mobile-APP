package com.example.skinwise.ui.profile

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
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
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
    private lateinit var userName: String
    private lateinit var userEmail: String
    private lateinit var userPhotoUrl: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logoutButton = view.findViewById<View>(R.id.filledTonalButton)
        val articleFav  = view.findViewById<View>(R.id.nextarticlefav)

        userNameTextView = view.findViewById(R.id.nameProfile)
        userPhotoImageView = view.findViewById(R.id.mainProfile)

        val editProfile = view.findViewById<View>(R.id.editProfileBtn)

        editProfile.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            intent.putExtra("USER_NAME", userName)
            intent.putExtra("USER_EMAIL", userEmail)
            intent.putExtra("USER_PHOTO_URL", userPhotoUrl)
            startActivity(intent)
        }

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
            userName = session.nama
            userEmail = session.email
            userPhotoUrl = session.photoUrl

            userNameTextView.text = userName
            Glide.with(requireContext()).load(userPhotoUrl).placeholder(R.drawable.ic_baseline_account_circle_24)
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
        val sharedPref = activity?.getSharedPreferences("session", Context.MODE_PRIVATE)
        sharedPref?.edit()?.clear()?.apply()

        val intent = Intent(activity, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        activity?.finish()
    }
}
