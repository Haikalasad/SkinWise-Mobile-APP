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
            1 -> OnboardingFragment1.newInstance(
                context.resources.getString(R.string.title_onboarding2),
                context.resources.getString(R.string.description_onboarding2),
                R.raw.scan
            )
            else -> OnboardingFragment1.newInstance(
                context.resources.getString(R.string.title_onboarding3),
                context.resources.getString(R.string.description_onboarding3),
                R.raw.doctor
            )
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}