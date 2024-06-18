package com.example.skinwise.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.skinwise.R
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import com.example.skinwise.ui.main.MainActivity
import com.example.skinwise.ui.welcome.OnBoardingActivity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

//@SuppressLint("CostumSplashScreen")
//class SplashScreenActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_splash_screen)
//
//        Handler(Looper.getMainLooper()).postDelayed({
//            goToMainActivity()
//        },3000L)
//    }
//
//    private fun goToMainActivity() {
//        Intent(this, MainActivity::class.java).also {
//            startActivity(it)
//            finish()
//        }
//    }
//
//}

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            checkLoginStatus()
        }, 3000L)
    }

    private fun checkLoginStatus() {
        // Simulasi pengecekan status login
        val userPreference = UserPreference.getInstance(applicationContext.dataStore)
        val isLoggedIn: Boolean

        runBlocking {
            isLoggedIn = userPreference.getSession().first().token.isNotEmpty()
        }

        val intent = if (isLoggedIn) {
            Intent(this, MainActivity::class.java)
        } else {
            Intent(this, OnBoardingActivity::class.java)
        }

        startActivity(intent)
        finish()
    }
}
