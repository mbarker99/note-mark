package com.mbarker99.notemark.auth.presentation.register

data class RegisterState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
