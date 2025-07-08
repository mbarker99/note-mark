package com.mbarker99.notemark.auth.presentation.login

sealed interface LoginAction {
    data class OnEmailChanged(val email: String): LoginAction
    data class OnPasswordChanged(val password: String): LoginAction
    data object OnLogInClicked: LoginAction
    data object OnDontHaveAnAccountClicked: LoginAction
}