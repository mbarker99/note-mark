package com.mbarker99.notemark.app.di

import com.mbarker99.notemark.app.NoteMarkApp
import com.mbarker99.notemark.core.data.remote.HttpClientFactory
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import io.ktor.client.engine.cio.CIO

val appModule = module {
    single<CoroutineScope> {
        (androidApplication() as NoteMarkApp).applicationScope
    }
    single { HttpClientFactory.create(CIO.create()) }
}