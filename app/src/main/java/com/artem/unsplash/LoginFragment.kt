package com.artem.unsplash

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment(R.layout.login) {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val buttonLogin: Button = view.findViewById(R.id.buttonLogin)
        val email: TextInputEditText = view.findViewById(R.id.email)
        val pass: TextInputEditText = view.findViewById(R.id.password)

        email.addTextChangedListener { newMail ->
            loginViewModel.emailChanged(newMail.toString())
        }

        pass.addTextChangedListener { newPass ->
            loginViewModel.passwordChanged(newPass.toString())
        }

        loginViewModel.email.observe(viewLifecycleOwner) { newEmail ->
            if (newEmail != email.text.toString()) {
                email.setText(newEmail)
            }
        }

        loginViewModel.password.observe(viewLifecycleOwner) { newPassword ->
            if (newPassword != pass.text.toString()) {
                email.setText(newPassword)
            }
        }

        loginViewModel.isValid.observe(viewLifecycleOwner) { isValid ->
            buttonLogin.isEnabled = isValid
        }

        buttonLogin.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
            findNavController().navigate(action)
        }
    }

}