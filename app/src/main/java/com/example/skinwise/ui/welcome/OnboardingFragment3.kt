package com.example.skinwise.ui.welcome

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.lottie.LottieAnimationView
import com.example.skinwise.R
import com.example.skinwise.databinding.FragmentOnboarding3Binding

class OnboardingFragment3 : Fragment() {
    private lateinit var title1: String
    private lateinit var title2: String
    private lateinit var title3: String
    private lateinit var description: String
    private var imageResource = 0
    private lateinit var tvTitle1: AppCompatTextView
    private lateinit var tvTitle2: AppCompatTextView
    private lateinit var tvTitle3: AppCompatTextView
    private lateinit var tvDescription: AppCompatTextView
    private lateinit var image: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            title1 = requireArguments().getString(ARG_PARAM1)!!
            title2 = requireArguments().getString(ARG_PARAM2)!!
            title3 = requireArguments().getString(ARG_PARAM3)!!
            description = requireArguments().getString(ARG_PARAM4)!!
            imageResource = requireArguments().getInt(ARG_PARAM5)
        }
    }

    private var _binding: FragmentOnboarding3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboarding3Binding.inflate(inflater, container, false)
        val view = binding.root
        tvTitle1 = binding.textOnboardingTitle
        tvTitle2 = binding.textOnboardingTitle2
        tvTitle3 = binding.textOnboardingTitle5
        tvDescription = binding.textOnboardingDescription
        image = binding.imageOnboarding2

        tvTitle1.text = title1
        tvTitle2.text = title2
        tvTitle3.text = title3
        tvDescription.text = description
        image.setAnimation(imageResource)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        private const val ARG_PARAM3 = "param3"
        private const val ARG_PARAM4 = "param4"
        private const val ARG_PARAM5 = "param5"

        fun newInstance(
            title1: String,
            title2: String,
            title3: String,
            description: String,
            imageResource: Int
        ): OnboardingFragment3 {
            val fragment = OnboardingFragment3()
            val args = Bundle()
            args.putString(ARG_PARAM1, title1)
            args.putString(ARG_PARAM2, title2)
            args.putString(ARG_PARAM3, title3)
            args.putString(ARG_PARAM4, description)
            args.putInt(ARG_PARAM5, imageResource)
            fragment.arguments = args
            return fragment
        }
    }
}
