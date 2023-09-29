package com.doersweb.tasky.interactor.authentication

interface AuthenticationInteractor {
    suspend fun isLoggedIn() : Boolean
    suspend fun registerUser(fullName: String, email: String, password: String)
    suspend fun signIn(email: String, password: String)
}