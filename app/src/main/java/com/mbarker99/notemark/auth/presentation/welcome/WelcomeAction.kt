package com.mbarker99.notemark.auth.presentation.welcome

sealed interface AuthAction {
    data object OnGetStartedClick: AuthAction
    data object OnLogInClick: AuthAction
}