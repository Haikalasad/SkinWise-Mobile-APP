package com.example.skinwise.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityLoginBinding
import com.example.skinwise.ui.signup.SignupActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        val text = getString(R.string.signupCTALink)

        val spannableString = SpannableString(text)
        val clickableSpan = object :ClickableSpan(){
            override fun onClick(v: View) {
                val intent = Intent(this@LoginActivity,SignupActivity::class.java)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }

        spannableString.setSpan(clickableSpan,0,text.length,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        loginBinding.signupCTALink.text = spannableString
        loginBinding.signupCTALink.movementMethod = LinkMovementMethod.getInstance()

    }
}