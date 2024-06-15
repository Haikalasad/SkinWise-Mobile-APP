package com.example.skinwise.ui.profile

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
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
import androidx.exifinterface.media.ExifInterface
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.skinwise.R
import com.example.skinwise.data.Result
import com.example.skinwise.databinding.ActivityEditProfileBinding
import com.example.skinwise.ui.main.ViewModelFactory
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
                val imageFile = uriToFile(uri, this).reduceImage()
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

    private fun uriToFile(uri: Uri, context: Context): File {
        val inputStream = context.contentResolver.openInputStream(uri)
        val tempFile = createCustomTempFile(context)
        inputStream?.use { input ->
            FileOutputStream(tempFile).use { output ->
                input.copyTo(output)
            }
        }
        return tempFile
    }

    private fun createCustomTempFile(context: Context): File {
        val timeStamp = System.currentTimeMillis()
        val filesDir = context.externalCacheDir ?: context.cacheDir
        return File.createTempFile("temp_$timeStamp", ".jpg", filesDir)
    }

    private fun File.reduceImage(): File {
        val options = BitmapFactory.Options().apply {
            inJustDecodeBounds = true
            BitmapFactory.decodeFile(this@reduceImage.path, this)
            val height = outHeight
            val width = outWidth
            val samples = 2.0.pow((ln(height / 1280.0) / ln(2.0) + ln(width / 1280.0) / ln(2.0)) / 2).roundToInt()
            inJustDecodeBounds = false
            inSampleSize = samples
        }
        var imageBitmap = BitmapFactory.decodeFile(this@reduceImage.path, options)

        try {
            val exif = ExifInterface(this@reduceImage.path)
            val orientation = exif.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL
            )

            val matrix = Matrix()
            when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> matrix.postRotate(90F)
                ExifInterface.ORIENTATION_ROTATE_180 -> matrix.postRotate(180F)
                ExifInterface.ORIENTATION_ROTATE_270 -> matrix.postRotate(270F)
            }

            imageBitmap = Bitmap.createBitmap(imageBitmap, 0, 0, imageBitmap.width, imageBitmap.height, matrix, true)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val outputStream = FileOutputStream(this@reduceImage)
        imageBitmap?.compress(Bitmap.CompressFormat.JPEG, 80, outputStream)
        outputStream.flush()
        outputStream.close()
        return this@reduceImage
    }
}
