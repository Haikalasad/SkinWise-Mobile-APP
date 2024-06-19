package com.example.skinwise.ui.welcome

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.skinwise.R

class OnboardingViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val context: Context
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment1.newInstance(
                context.resources.getString(R.string.title_onboarding),
                context.resources.getString(R.string.description_onboarding),
                R.raw.hello
            )
            1 -> OnboardingFragment2.newInstance(
                context.resources.getString(R.string.title_onboarding3),  // Title1 sesuai XML
                context.resources.getString(R.string.title_onboarding4),  // Title2 sesuai XML
                context.resources.getString(R.string.title_onboarding5),  // Title3 sesuai XML
                context.resources.getString(R.string.description_onboarding2),  // Description sesuai XML
                R.raw.scan  // Image sesuai XML
            )
            else -> OnboardingFragment3.newInstance(
                context.resources.getString(R.string.title_onboarding6),  // Title1 sesuai XML
                context.resources.getString(R.string.title_onboarding7),  // Title2 sesuai XML
                context.resources.getString(R.string.title_onboarding8),  // Title3 sesuai XML
                context.resources.getString(R.string.description_onboarding3),  // Description sesuai XML
                R.raw.doctor
            )  // Image sesuai XML
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}