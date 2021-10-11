package com.artem.unsplash.on_boarding_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.artem.unsplash.R
import com.artem.unsplash.databinding.OnBoarding3Binding

class OnBoardingItem3Fragment : Fragment(R.layout.on_boarding_3) {

    private val binding: OnBoarding3Binding by viewBinding(OnBoarding3Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.continueToLogin.setOnClickListener {
            val action = OnBoardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }
}