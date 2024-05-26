package com.example.skinwise.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.TextUtils
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.skinwise.R
import com.example.skinwise.data.Result
import com.example.skinwise.databinding.ActivitySignupBinding
import com.example.skinwise.ui.ViewModelFactory
import com.example.skinwise.ui.login.LoginActivity

class SignupActivity : AppCompatActivity() {
    private lateinit var binding
: ActivitySignupBinding
    private lateinit var factory : ViewModelFactory
    private val signupViewModel : SignupViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        factory = ViewModelFactory.getInstance(this)
        signupViewModel.setLoading(false)
        registerButtonHandler()
        observeLoading()

        val text = getString(R.string.loginCTALink)
        val spannableString = SpannableString(text)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
        spannableString.setSpan(clickableSpan, 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.loginCTALink.text = spannableString
        binding.loginCTALink.movementMethod = LinkMovementMethod.getInstance()

    }

    private fun registerButtonHandler(){
        binding.signupButton.setOnClickListener {
            val email = binding.edSignupEmail.text.toString()
            val password = binding.edSignupPassword.text.toString()
            val nama = binding.edSignupName.text.toString()

            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(nama)) {
                handleRegister(nama, email, password)
            } else {
                Log.e("Register Activity","Gagal")
            }

        }
    }

    private fun handleRegister(nama:String,email : String, password : String){
        signupViewModel.setLoading(true)
        signupViewModel.register(nama, email, password)
        signupViewModel.registerResult.observe(this){ result->
            when(result){
                is Result.Success ->{
                    Toast.makeText(this@SignupActivity, "Registrasi berhasil", Toast.LENGTH_SHORT)
                        .show()
                    moveTologin()
                }
                is Result.Error-> {
                    Toast.makeText(this@SignupActivity, "Registrasi gagal", Toast.LENGTH_SHORT)
                        .show()
                }

                else -> {
                    Toast.makeText(this@SignupActivity, "Registrasi gagal", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun passEditTextHandler() {
        val passEditText = binding.edSignupPassword
        passEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(s.toString().length < 8){
                    passEditText.setError("Password tidak boleh kurang dari 8 karakter")
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }
        })
    }


    private fun moveTologin(){
        val intent = Intent(this@SignupActivity,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun observeLoading() {
        signupViewModel.isLoading.observe(this@SignupActivity) { isLoading ->
            showLoading(isLoading)
        }
    }

    private fun showLoading(state: Boolean) {
        binding.loading.visibility = if (state) View.VISIBLE else View.GONE
    }


}