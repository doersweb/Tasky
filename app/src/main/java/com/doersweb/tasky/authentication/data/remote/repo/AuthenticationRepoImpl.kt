package com.doersweb.tasky.authentication.data.remote.repo

import com.doersweb.tasky.authentication.data.prefs.AuthPreferences
import com.doersweb.tasky.authentication.data.remote.AuthenticationApi
import com.doersweb.tasky.data.dto.UserRegistrationData
import com.doersweb.tasky.data.dto.SignInUser
import com.doersweb.tasky.data.remote.response.SigninResponse
import com.doersweb.tasky.data.util.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthenticationRepoImpl(
    private val authenticationApi: AuthenticationApi,
    private val authPreferences: AuthPreferences,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthenticationRepo {
    override suspend fun signIn(signInUser: SignInUser): ApiResponse<SigninResponse> {
        return withContext(dispatcher) {
            val result = authenticationApi.signIn(signInUser)
            ApiResponse.Success(result)
        }
    }

    override suspend fun register(userRegistrationData: UserRegistrationData): ApiResponse<String> {
        return withContext(dispatcher) {
            authenticationApi.register(userRegistrationData)
            ApiResponse.Success("Success")
        }
    }

    override suspend fun getAuthToken(): String? = authPreferences.fetchToken()

}