package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class ActivityViewModel : ViewModel() {
    private val _isUserLoggedIn = MutableStateFlow(false)
    val isUserLoggedIn = _isUserLoggedIn.asLiveData(viewModelScope.coroutineContext)

    fun login() = flow<LoginState> {
        delay(2000)
        _isUserLoggedIn.value = true
        emit(LoginState.Success)
    }.onStart {
        emit(LoginState.Progress)
    }.asLiveData(viewModelScope.coroutineContext)

    sealed interface LoginState {
        object Progress : LoginState
        object Success : LoginState
    }
}