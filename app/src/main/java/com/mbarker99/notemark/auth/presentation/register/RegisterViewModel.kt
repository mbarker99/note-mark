package com.mbarker99.notemark.auth.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbarker99.notemark.auth.domain.AuthDataSource
import com.mbarker99.notemark.core.domain.util.Result
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val authDataSource: AuthDataSource
) : ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    private val eventChannel = Channel<RegisterEvent>()
    val events = eventChannel.receiveAsFlow()

    fun onAction(action: RegisterAction) {
        when (action) {
            is RegisterAction.OnUsernameChanged -> onUsernameChanged(action.username)
            is RegisterAction.OnEmailChanged -> onEmailChanged(action.email)
            is RegisterAction.OnPasswordChanged -> onPasswordChanged(action.password)
            is RegisterAction.OnConfirmPasswordChanged -> onConfirmPasswordChanged(action.password)
            RegisterAction.OnCreateAccountClicked -> onCreateAccountClicked()
            else -> Unit
        }
    }

    private fun onCreateAccountClicked() {
        viewModelScope.launch {
            val result = authDataSource.registerNewUser(
                username = state.value.username,
                email = state.value.email,
                password = state.value.password
            )
            when (result) {
                is Result.Success -> eventChannel.send(RegisterEvent.OnRegistrationSuccess)
                is Result.Error -> eventChannel.send(RegisterEvent.OnRegistrationFailed)
            }
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