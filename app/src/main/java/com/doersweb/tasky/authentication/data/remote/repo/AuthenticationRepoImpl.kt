package com.doersweb.tasky.data.remote.repo.authentication

import com.doersweb.tasky.authentication.data.prefs.AuthPreferences
import com.doersweb.tasky.authentication.data.remote.AuthenticationApi
import javax.inject.Singleton

class AuthenticationRepoImpl(
    authenticationApi: AuthenticationApi,
    authPreferences: AuthPreferences
) : AuthenticationRepo {
    override suspend fun signIn() {
        TODO("Not yet implemented")
    }

    override suspend fun register() {
        TODO("Not yet implemented")
    }

    override suspend fun getAuthToken() {
        TODO("Not yet implemented")
    }
}