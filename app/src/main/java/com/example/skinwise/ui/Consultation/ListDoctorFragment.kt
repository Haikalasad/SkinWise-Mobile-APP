package com.example.skinwise.ui.Consultation

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinwise.R
import com.example.skinwise.adapter.DoctorAdapter
import com.example.skinwise.databinding.FragmentListDoctorBinding
import com.example.skinwise.ui.main.ViewModelFactory

class ListDoctorFragment : Fragment() {

    private lateinit var binding: FragmentListDoctorBinding
    private lateinit var factory: ViewModelFactory
    private val viewModel: ConsultationViewModel by viewModels { factory }
    private lateinit var doctorAdapter: DoctorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = ViewModelFactory.getInstance(requireContext())

        binding.toolbar.apply {
            title = "Konsultasi Dokter"
            (requireActivity() as AppCompatActivity).setSupportActionBar(this)
            (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            val upArrow: Drawable? = ContextCompat.getDrawable(requireContext(), R.drawable.baseline_arrow_back_24)
            (requireActivity() as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(upArrow)
        }

        doctorAdapter = DoctorAdapter()
        binding.rvListArticle.adapter = doctorAdapter
        binding.rvListArticle.layoutManager = LinearLayoutManager(requireContext())

        viewModel.doctors.observe(viewLifecycleOwner) {
            doctorAdapter.submitList(it)
        }

        viewModel.fetchListDoctors()
    }
}
