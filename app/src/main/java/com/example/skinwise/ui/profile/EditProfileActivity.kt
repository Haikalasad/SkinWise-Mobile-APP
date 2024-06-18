package com.example.skinwise.ui.profile


import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.Result
import com.example.skinwise.databinding.ActivityEditProfileBinding
import com.example.skinwise.ui.main.ViewModelFactory
import com.example.skinwise.ui.result.fromUriToFile
import kotlinx.coroutines.launch
import java.io.*
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.roundToInt

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var factory: ViewModelFactory
    private var currentImageUri: Uri? = null
    private val viewModel: EditProfileViewModel by viewModels { factory }


    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            currentImageUri = it
            showImage()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        factory = ViewModelFactory.getInstance(this)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val userName = intent.getStringExtra("USER_NAME")
        val userEmail = intent.getStringExtra("USER_EMAIL")
        val userPhotoUrl = intent.getStringExtra("USER_PHOTO_URL")
        if (userName != null && userEmail != null) {
            Log.d("EditProfile", "Name: $userName, Email: $userEmail")
        } else {
            Log.e("EditProfile", "Failed to retrieve user data from intent")
        }

        binding.edName.text = userName.toEditable()
        binding.edEmail.text = userEmail.toEditable()
        Glide.with(this)
            .load(userPhotoUrl)
            .placeholder(R.drawable.ic_baseline_account_circle_24)
            .error(R.drawable.ic_baseline_account_circle_24)
            .into(binding.mainProfile)

        binding.editphoto.setOnClickListener {
            startGallery()
        }

        binding.saveButton.setOnClickListener {
            val name = binding.edName.text.toString()
            val email = binding.edEmail.text.toString()

            currentImageUri?.let { uri ->
                val imageFile = fromUriToFile(uri, this)
                lifecycleScope.launch {
                    viewModel.updateProfile(imageFile, name, email)
                }
            } ?: run {
                lifecycleScope.launch {
                    viewModel.updateProfile(null, name, email)
                }
            }
        }


        lifecycleScope.launch {
            viewModel.updateResult.collect { result ->
                when (result) {
                    is Result.Success -> {
                        Toast.makeText(this@EditProfileActivity, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                    }
                    is Result.Error -> {
                        Toast.makeText(this@EditProfileActivity, "Failed to update profile: ${result.data}", Toast.LENGTH_SHORT).show()
                        Log.e("EditProfile", "Failed to update data : ${result.data}")
                    }
                    else -> {}
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.info_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.action_faq -> {
                Toast.makeText(this, "FAQ clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun String?.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun startGallery() {
        launcherGallery.launch("image/*")
    }

    private fun showImage() {
        currentImageUri?.let {
            Glide.with(this)
                .load(it)
                .placeholder(R.drawable.ic_baseline_account_circle_24)
                .error(R.drawable.ic_baseline_account_circle_24)
                .into(binding.mainProfile)
        }
    }

}
