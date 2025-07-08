package com.mbarker99.notemark.auth.presentation.register

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    fun onAction(action: RegisterAction) {
        when (action) {
            is RegisterAction.OnUsernameChanged -> onUsernameChanged(action.username)
            is RegisterAction.OnEmailChanged -> onEmailChanged(action.email)
            is RegisterAction.OnPasswordChanged -> onPasswordChanged(action.password)
            is RegisterAction.OnConfirmPasswordChanged -> onConfirmPasswordChanged(action.password)
            RegisterAction.OnCreateAccountClicked -> TODO("Register function")
            else -> Unit
        }
    }

    private fun onConfirmPasswordChanged(password: String) {
        _state.update {
            it.copy(
                confirmPassword = password
            )
        }
    }

    private fun onPasswordChanged(password: String) {
        _state.update {
            it.copy(
                password = password
            )
        }
    }

    private fun onUsernameChanged(username: String) {
        _state.update {
            it.copy(
                username = username
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