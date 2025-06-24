package com.mbarker99.notemark.auth.presentation

sealed class AuthAction {
    data object OnGetStartedClick: AuthAction()
    data object OnLogInClick: AuthAction()

    data class OnEmailChange(val email: String): AuthAction()
    data class OnPasswordChange(val password: String): AuthAction()

    data class OnUsernameChange(val username: String): AuthAction()
    data class OnConfirmPasswordChange(val confirmPassword: String): AuthAction()
}
