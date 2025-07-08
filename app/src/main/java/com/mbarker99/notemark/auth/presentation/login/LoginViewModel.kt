package com.mbarker99.notemark.auth.presentation.login

import androidx.compose.runtime.MutableState
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

class LoginViewModel(
    private val authDataSource: AuthDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    val eventChannel = Channel<LoginEvent>()
    val events = eventChannel.receiveAsFlow()

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnEmailChanged -> onEmailChanged(action.email)
            is LoginAction.OnPasswordChanged -> onPasswordChanged(action.password)
            LoginAction.OnLogInClicked -> onLoginClicked()
            else -> Unit
        }
    }

    private fun onLoginClicked() {
        viewModelScope.launch {
            val result = authDataSource.login(
                email = state.value.email,
                password = state.value.password
            )
            when (result) {
                is Result.Success -> eventChannel.send(LoginEvent.OnLoginSuccessful)
                is Result.Error -> eventChannel.send(LoginEvent.OnLoginFailed)
            }
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