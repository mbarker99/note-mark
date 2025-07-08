package com.mbarker99.notemark.auth.domain

import com.mbarker99.notemark.core.domain.util.EmptyResult
import com.mbarker99.notemark.core.domain.util.Error
import com.mbarker99.notemark.core.domain.util.NetworkError
import com.mbarker99.notemark.core.domain.util.Result

interface AuthDataSource {
    suspend fun registerNewUser(username: String, email: String, password: String): EmptyResult<NetworkError>
    suspend fun login(email: String, password: String): EmptyResult<NetworkError>
    suspend fun refreshToken(refreshToken: String)
}