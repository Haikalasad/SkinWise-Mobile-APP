package com.example.skinwise.ui.Consultation


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinwise.adapter.DoctorAdapter
import com.example.skinwise.databinding.FragmentListDoctorBinding
import com.example.skinwise.ui.main.ViewModelFactory
import com.example.skinwise.data.Result


class ListDoctorFragment : Fragment() {

    private var _binding: FragmentListDoctorBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : ConsultationViewModel


    private lateinit var doctorAdapter: DoctorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = context?.let { ViewModelFactory.getInstance(it) }

        viewModel = viewModelFactory?.let {
            ViewModelProvider(this,
                it
            )[ConsultationViewModel::class.java]
        }!!

        doctorAdapter = DoctorAdapter()
        binding.rvListArticle.adapter = doctorAdapter
        binding.rvListArticle.layoutManager = LinearLayoutManager(requireContext())

        viewModel.doctorsResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Success -> {
                    result.data.let { doctorResponse ->
                        doctorAdapter.submitList(doctorResponse.data?.doctors)
                    }
                }
                is Result.Error -> {
                    Log.e("ListDoctorFragment", "Gagal mendapatkan list dokter: ${result.data}")
                }

                else -> {
                    Log.e("ListDoctorFragment","Unknown Error Occured")
                }
            }
        }


        viewModel.getAllDoctors()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
