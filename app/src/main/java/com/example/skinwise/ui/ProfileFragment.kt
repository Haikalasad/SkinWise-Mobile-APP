package com.example.skinwise.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.skinwise.R
import com.example.skinwise.ui.article.ArticleActivity
import com.example.skinwise.ui.login.LoginActivity

class ProfileFragment : Fragment() {

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

        logoutButton.setOnClickListener {
            showLogoutConfirmationDialog()
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
        val sharedPref = activity?.getSharedPreferences("user_session", Context.MODE_PRIVATE)
        sharedPref?.edit()?.clear()?.apply()

        // Navigate to login screen
        val intent = Intent(activity, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        activity?.finish()
    }
}
