package com.mbarker99.notemark.auth.presentation.welcome

sealed class WelcomeScreenAction {
    data object OnGetStartedClick: WelcomeScreenAction()
    data object OnLogInClick: WelcomeScreenAction()
}
