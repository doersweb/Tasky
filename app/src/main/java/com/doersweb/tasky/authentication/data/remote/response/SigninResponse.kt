package com.doersweb.tasky.data.remote.response

data class SigninResponse(
    val token: String,
    val userId: String,
    val fullName: String
)
