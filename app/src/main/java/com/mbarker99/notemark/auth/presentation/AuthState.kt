package com.mbarker99.notemark.auth.presentation

data class AuthState(
    var isLoading: Boolean = false,
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = "",
)
