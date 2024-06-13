package com.example.skinwise.ui.main

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.example.skinwise.R
import com.example.skinwise.ui.HomeFragment
import com.example.skinwise.ui.ProfileFragment
import com.example.skinwise.ui.Result.ResultActivity
import com.example.skinwise.ui.Consultation.ConsultationFragment
import com.example.skinwise.ui.hospital.HospitalFragment
import com.example.skinwise.ui.welcome.WelcomeActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 102
    private val GALLERY_REQUEST_CODE = 103

    private var photoURI: Uri? = null
    private var displayResult: String? = null

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private val requestCameraPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                openCamera()
            } else {
                showToast("Permission Denied")
            }
        }

    private val requestGalleryPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                openGallery()
            } else {
                showToast("Permission Denied")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getSession().observe(this) { user ->
            if (!user.isLogin) {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            } else {
                HomeFragment()
            }
        }

        // Hide the action bar
        supportActionBar?.hide()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set background to null
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.action_home -> selectedFragment = HomeFragment()
                R.id.action_profile -> selectedFragment = ProfileFragment()
                R.id.action_hospital -> selectedFragment = HospitalFragment()
                R.id.action_consultation-> selectedFragment = ConsultationFragment()
            }

            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit()
            }
            true
        }

        // Set default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        // Handle floating action button click
        val fab = findViewById<FloatingActionButton>(R.id.fabScan)
        fab.setOnClickListener {
            showPictureDialog()
        }
    }

    private fun showPictureDialog() {
        val pictureDialog = AlertDialog.Builder(this)
        pictureDialog.setTitle("Ambil gambar melalui")
        val pictureDialogItems = arrayOf("Camera", "Gallery")
        pictureDialog.setItems(pictureDialogItems) { _, which ->
            when (which) {
                0 -> requestCameraPermission()
                1 -> requestGalleryPermission()
            }
        }
        pictureDialog.show()
    }

    private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
                openCamera()
            }
            ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) -> {
                showPermissionExplanationDialog(
                    "Camera permission is needed to take pictures",
                    Manifest.permission.CAMERA,
                    requestCameraPermissionLauncher
                )
            }
            else -> {
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun requestGalleryPermission() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED -> {
                openGallery()
            }
            ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                showPermissionExplanationDialog(
                    "Storage permission is needed to access gallery",
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    requestGalleryPermissionLauncher
                )
            }
            else -> {
                requestGalleryPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }

    private fun showPermissionExplanationDialog(message: String, permission: String, launcher: androidx.activity.result.ActivityResultLauncher<String>) {
        AlertDialog.Builder(this)
            .setTitle("Permission needed")
            .setMessage(message)
            .setPositiveButton("OK") { _, _ ->
                launcher.launch(permission)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            val photoFile: File? = try {
                createImageFile()
            } catch (ex: IOException) {
                null
            }
            photoFile?.also {
                photoURI = FileProvider.getUriForFile(
                    this,
                    "${applicationContext.packageName}.fileprovider",
                    it
                )
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            }
        }
    }

    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE)
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            currentPhotoPath = absolutePath
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                CAMERA_REQUEST_CODE -> {
                    photoURI?.let {
                        analyzeImage(it)
                    }
                }
                GALLERY_REQUEST_CODE -> {
                    val selectedImage = data?.data
                    selectedImage?.let {
                        analyzeImage(it)
                    }
                }
            }
        }
    }

    private fun analyzeImage(imageUri: Uri) {
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra(ResultActivity.IMAGE_URI, imageUri.toString())
        }
        startActivityForResult(intent, REQUEST_RESULT)
    }

    companion object {
        private const val REQUEST_RESULT = 104
        private var currentPhotoPath: String? = null
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
