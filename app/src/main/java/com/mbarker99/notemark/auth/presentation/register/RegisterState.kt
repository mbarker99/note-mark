package com.mbarker99.notemark.auth.presentation.register

data class RegisterState(
    val isLoading: Boolean = false,
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isConfirmButtonEnabled: Boolean = true
)
