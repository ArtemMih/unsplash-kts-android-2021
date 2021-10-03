package com.artem.unsplash.login_fragment

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LoginViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val emailLiveData = savedStateHandle.getLiveData<String>("email")
    private val passwordLiveData = savedStateHandle.getLiveData<String>("password")
    private val isValidLiveData = savedStateHandle.getLiveData<Boolean>("isValid")

    val email: LiveData<String>
        get() = emailLiveData

    val password: LiveData<String>
        get() = passwordLiveData

    val isValid: LiveData<Boolean>
        get() = isValidLiveData

    init {
        checkIsValid(email.value ?: "", password.value ?: "")
    }

    fun emailChanged(newEmail: String) {
        savedStateHandle["email"] = newEmail
        checkIsValid(newEmail, password.value ?: "")
    }

    fun passwordChanged(newPassword: String) {
        savedStateHandle["password"] = newPassword
        checkIsValid(email.value ?: "", newPassword)
    }

    private fun checkIsValid(email: String, password: String) {
        val emailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        savedStateHandle["isValid"] = emailValid && password.length >= 8
    }

}