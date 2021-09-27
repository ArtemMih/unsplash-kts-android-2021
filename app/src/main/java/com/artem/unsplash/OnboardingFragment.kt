package com.artem.unsplash

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import timber.log.Timber

class OnboardingFragment: Fragment(R.layout.onboarding) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val continueToLogin = view.findViewById<Button>(R.id.continue_to_login)
        continueToLogin.setOnClickListener {
            val action = OnboardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("onDetach")
    }

}