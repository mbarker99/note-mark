package com.mbarker99.notemark.auth.presentation.login

data class LoginState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val isConfirmButtonEnabled: Boolean = true
)
