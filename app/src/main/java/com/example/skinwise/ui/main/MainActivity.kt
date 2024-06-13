package com.example.skinwise.ui.main

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.skinwise.R
import com.example.skinwise.databinding.ActivityMainBinding
import com.example.skinwise.ui.Consultation.ListDoctorFragment
import com.example.skinwise.ui.HomeFragment
import com.example.skinwise.ui.ProfileFragment
import com.example.skinwise.ui.Result.ResultActivity
import com.example.skinwise.ui.Consultation.ConsultationFragment
import com.example.skinwise.ui.hospital.HospitalFragment
import com.example.skinwise.ui.welcome.WelcomeActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 102

    private lateinit var binding: ActivityMainBinding

    private var currentImageUri: Uri? = null
    private var displayResult: String? = null

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "Permission request granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Permission request denied", Toast.LENGTH_LONG).show()
            }
        }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getSession().observe(this) { user ->
            if (!user.isLogin) {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
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

        if (!allPermissionsGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
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
                0 -> startCamera()
                1 -> startGallery()
            }
        }
        pictureDialog.show()
    }

    private fun generateUniqueFilename(): String {
        val timestamp = System.currentTimeMillis().toString()
        return "analyzed_image_$timestamp.jpg"
    }

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImagePreview(uri)
        } else {
            showToast("No media selected")
        }
    }

    private fun startCamera() {
        currentImageUri = getImageUri(this)
        launcherIntentCamera.launch(currentImageUri)
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            currentImageUri?.let {
                showImagePreview(it)
            }
        }
    }

    private fun getImageUri(context: Context): Uri {
        val filename = generateUniqueFilename()
        val values = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, filename)
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        }
        return context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)!!
    }

    private fun showImagePreview(imageUri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(imageUri, "image/*")
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }
        startActivityForResult(intent, REQUEST_IMAGE_PREVIEW)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_PREVIEW && resultCode == RESULT_OK) {
            moveToResult()
        }
    }

    private fun moveToResult() {
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra(ResultActivity.EXTRA_RESULT, displayResult)
            putExtra(ResultActivity.EXTRA_IMG, currentImageUri.toString())
        }
        startActivity(intent)
    }

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
        private const val REQUEST_IMAGE_PREVIEW = 103
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
