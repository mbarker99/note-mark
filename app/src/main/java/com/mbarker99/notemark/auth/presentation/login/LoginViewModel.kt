package com.mbarker99.notemark.auth.presentation.login

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel() : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnEmailChanged -> onEmailChanged(action.email)
            is LoginAction.OnPasswordChanged -> onPasswordChanged(action.password)
            LoginAction.OnLogInClicked -> { TODO("Login function") }
            else -> Unit
        }
    }

    private fun onPasswordChanged(password: String) {
        _state.update {
            it.copy(
                password = password
            )
        }
    }

    private fun onEmailChanged(email: String) {
        _state.update {
            it.copy(
                email = email
            )
        }
    }
}