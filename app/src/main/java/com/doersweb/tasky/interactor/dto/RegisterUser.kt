package com.doersweb.tasky.interactor.dto

data class RegisterUser(
    val fullName: String,
    val email: String,
    val password: String
)
