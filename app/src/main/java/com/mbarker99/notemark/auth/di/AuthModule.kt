package com.mbarker99.notemark.auth.di

import com.mbarker99.notemark.auth.data.remote.api.KtorAuthDataSource
import com.mbarker99.notemark.auth.domain.AuthDataSource
import com.mbarker99.notemark.auth.presentation.login.LoginViewModel
import com.mbarker99.notemark.auth.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authModule = module {
    singleOf(::KtorAuthDataSource) bind AuthDataSource::class

    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}