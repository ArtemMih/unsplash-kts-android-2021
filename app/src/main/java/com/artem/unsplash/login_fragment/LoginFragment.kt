package com.artem.unsplash.login_fragment

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.artem.unsplash.R
import com.artem.unsplash.databinding.LoginBinding

class LoginFragment : Fragment(R.layout.login) {

    private val binding: LoginBinding by viewBinding(LoginBinding::bind)
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.email.addTextChangedListener { newMail ->
            loginViewModel.emailChanged(newMail.toString())
        }

        binding.password.addTextChangedListener { newPass ->
            loginViewModel.passwordChanged(newPass.toString())
        }

        loginViewModel.email.observe(viewLifecycleOwner) { newEmail ->
            if (newEmail != binding.email.text.toString()) {
                binding.email.setText(newEmail)
            }
        }

        loginViewModel.password.observe(viewLifecycleOwner) { newPassword ->
            if (newPassword != binding.password.text.toString()) {
                binding.email.setText(newPassword)
            }
        }

        loginViewModel.isValid.observe(viewLifecycleOwner) { isValid ->
            binding.buttonLogin.isEnabled = isValid
        }

        binding.buttonLogin.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
            findNavController().navigate(action)
        }
    }

}