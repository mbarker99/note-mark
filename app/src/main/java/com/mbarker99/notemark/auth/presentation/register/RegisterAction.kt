package com.mbarker99.notemark.auth.presentation.register

sealed interface RegisterAction {
    data class OnUsernameChanged(val username: String): RegisterAction
    data class OnEmailChanged(val email: String): RegisterAction
    data class OnPasswordChanged(val password: String): RegisterAction
    data class OnConfirmPasswordChanged(val password: String): RegisterAction
    data object OnCreateAccountClicked: RegisterAction
    data object OnAlreadyHaveAnAccountClicked: RegisterAction
}