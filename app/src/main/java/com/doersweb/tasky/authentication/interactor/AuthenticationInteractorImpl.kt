package com.doersweb.tasky.authentication.interactor

import com.doersweb.tasky.data.remote.repo.authentication.AuthenticationRepo

class AuthenticationInteractorImpl(
    authenticationRepo: AuthenticationRepo
): AuthenticationInteractor {
    override suspend fun isLoggedIn(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun registerUser(fullName: String, email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun signIn(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getAuthenticationToken(): String? {
        TODO("Not yet implemented")
    }

}