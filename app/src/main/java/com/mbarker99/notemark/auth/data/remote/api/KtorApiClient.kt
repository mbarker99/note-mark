package com.mbarker99.notemark.auth.data.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType.Application.Json

class KtorApiClient {
    private val httpClient = HttpClient {
        install(Logging) {
            level = LogLevel.ALL
        }
    }
}