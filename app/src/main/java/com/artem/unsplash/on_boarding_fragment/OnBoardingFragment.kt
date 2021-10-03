package com.artem.unsplash.on_boarding_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.artem.unsplash.R
import com.artem.unsplash.databinding.OnBoardingBinding

class OnBoardingFragment : Fragment(R.layout.on_boarding) {

    private val binding: OnBoardingBinding by viewBinding(OnBoardingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.continueToLogin.setOnClickListener {
            val action = OnBoardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }

}