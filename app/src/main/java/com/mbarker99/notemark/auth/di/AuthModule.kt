package com.mbarker99.notemark.auth.di

import com.mbarker99.notemark.auth.presentation.login.LoginViewModel
import com.mbarker99.notemark.auth.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}