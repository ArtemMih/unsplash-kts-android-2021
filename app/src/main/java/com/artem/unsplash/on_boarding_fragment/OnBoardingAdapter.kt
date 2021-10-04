package com.artem.unsplash.on_boarding_fragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnBoardingItem1Fragment()
            1 -> OnBoardingItem2Fragment()
            else -> OnBoardingItem3Fragment()
        }
    }

}