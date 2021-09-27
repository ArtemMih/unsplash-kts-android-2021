package com.artem.unsplash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {

    private val emailLiveData = savedStateHandle.getLiveData<String>("email")
    private val passwordLiveData = savedStateHandle.getLiveData<String>("password")

    val email: LiveData<String>
        get() = emailLiveData

    val password: LiveData<String>
        get() = passwordLiveData


    fun emailChanged(email:String) {
        savedStateHandle["email"] = email
    }

    fun passwordChanged(password:String) {
        savedStateHandle["password"] = password
    }

}