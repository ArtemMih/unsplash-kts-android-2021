package com.artem.unsplash

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class OnBoardingFragment : Fragment(R.layout.onboarding) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val continueToLogin = view.findViewById<Button>(R.id.continue_to_login)
        continueToLogin.setOnClickListener {
            val action = OnBoardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }

}