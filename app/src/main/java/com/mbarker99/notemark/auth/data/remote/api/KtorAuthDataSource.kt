package com.mbarker99.notemark.auth.data.remote.api

import com.mbarker99.notemark.auth.data.remote.dto.LoginRequest
import com.mbarker99.notemark.auth.data.remote.dto.LoginResponse
import com.mbarker99.notemark.auth.data.remote.dto.RegisterRequest
import com.mbarker99.notemark.auth.domain.AuthDataSource
import com.mbarker99.notemark.core.data.remote.post
import com.mbarker99.notemark.core.domain.util.EmptyResult
import com.mbarker99.notemark.core.domain.util.NetworkError
import com.mbarker99.notemark.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class KtorAuthDataSource(
    private val httpClient: HttpClient
): AuthDataSource {
    override suspend fun registerNewUser(
        username: String,
        email: String,
        password: String
    ): EmptyResult<NetworkError> {
        return httpClient.post<RegisterRequest, Unit>(
            route = ApiUrl.REGISTRATION,
            body = RegisterRequest(
                username = username,
                email = email,
                password = password
            )
        )
    }

    override suspend fun login(email: String, password: String): EmptyResult<NetworkError> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = ApiUrl.LOGIN,
            body = LoginRequest(
                email = email,
                password = password
            )
        )

        return result.asEmptyDataResult()
    }

    override suspend fun refreshToken(refreshToken: String) {
        TODO("Not yet implemented")
    }
}