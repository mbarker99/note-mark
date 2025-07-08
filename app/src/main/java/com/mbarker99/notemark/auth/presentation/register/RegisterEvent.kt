package com.mbarker99.notemark.auth.presentation.register

sealed interface RegisterEvent {
    data object OnRegistrationSuccess: RegisterEvent
    data object OnRegistrationFailed: RegisterEvent
}