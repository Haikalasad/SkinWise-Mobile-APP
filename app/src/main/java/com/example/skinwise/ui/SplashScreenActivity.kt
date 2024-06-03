package com.example.skinwise.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.skinwise.R
import com.example.skinwise.ui.main.MainActivity

@SuppressLint("CostumSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        },3000L)
    }

    private fun goToMainActivity() {
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }

}