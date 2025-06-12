package com.mbarker99.notemark.auth.presentation.welcome

import androidx.lifecycle.ViewModel

class WelcomeViewModel(): ViewModel() {
    fun onAction(action: WelcomeScreenAction) {
        when (action) {
            is WelcomeScreenAction.OnLogInClick -> {

            }

            WelcomeScreenAction.OnGetStartedClick -> TODO()
        }
    }
}