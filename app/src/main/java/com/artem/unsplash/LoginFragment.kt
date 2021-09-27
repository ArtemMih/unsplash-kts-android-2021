package com.artem.unsplash

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class LoginFragment: Fragment(R.layout.login) {

    private val loginViewModel: LoginViewModel by viewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonLogin: Button = view.findViewById(R.id.buttonLogin)
        val email: TextInputEditText = view.findViewById(R.id.email)
        val pass: TextInputEditText = view.findViewById(R.id.password)


        loginViewModel.email.observe(viewLifecycleOwner){ newEmail ->
            if (newEmail != email.text.toString()) {
                email.setText(newEmail)
            }
        }

        loginViewModel.password.observe(viewLifecycleOwner){ newPassword ->
            if (newPassword != pass.text.toString()) {
                email.setText(newPassword)
            }
        }



        buttonLogin.setOnClickListener {
            val isValid = Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()
            if (pass.text.toString().length >= 8 && isValid){
                val action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
                findNavController().navigate(action)
            }
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