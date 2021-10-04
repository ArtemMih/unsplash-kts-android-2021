package com.artem.unsplash.on_boarding_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.artem.unsplash.R
import com.artem.unsplash.databinding.OnBoardingBinding

class OnBoardingFragment : Fragment(R.layout.on_boarding) {

    private val binding: OnBoardingBinding by viewBinding(OnBoardingBinding::bind)

    private lateinit var onBoardingAdapter: OnBoardingAdapter
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBoardingAdapter = OnBoardingAdapter(this)
        viewPager = binding.onBoardingViewPager
        viewPager.adapter = onBoardingAdapter
        binding.indicator.attachToPager(viewPager)
    }

}