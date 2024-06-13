package com.example.skinwise.ui.Consultation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.skinwise.databinding.FragmentConsultationBinding
import com.example.skinwise.ui.Consultation.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ConsultationFragment : Fragment() {

    private var _binding: FragmentConsultationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConsultationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: Toolbar = binding.toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Konsultasi"

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = ViewPagerAdapter(requireActivity())
        viewPager.adapter = adapter
        TabLayoutMediator(
            tabLayout, viewPager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "List Dokter"
                1 -> tab.text = "Chat"
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
