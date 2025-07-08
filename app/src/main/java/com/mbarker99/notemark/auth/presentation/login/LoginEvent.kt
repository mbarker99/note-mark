package com.mbarker99.notemark.auth.presentation.login

sealed interface LoginEvent {
    data object OnLoginSuccessful: LoginEvent
    data object OnLoginFailed: LoginEvent
}