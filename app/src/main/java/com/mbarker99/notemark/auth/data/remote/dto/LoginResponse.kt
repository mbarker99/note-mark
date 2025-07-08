package com.mbarker99.notemark.auth.data.remote.dto

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val username: String
)
