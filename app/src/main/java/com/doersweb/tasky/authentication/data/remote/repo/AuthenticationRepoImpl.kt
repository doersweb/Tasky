package com.doersweb.tasky.authentication.data.remote.repo

import com.doersweb.calorietracker.BuildConfig
import com.doersweb.tasky.authentication.data.prefs.AuthPreferences
import com.doersweb.tasky.authentication.data.remote.AuthenticationApi
import com.doersweb.tasky.data.dto.RegisterUser
import com.doersweb.tasky.data.dto.SignInUser
import com.doersweb.tasky.data.remote.response.SigninResponse
import com.doersweb.tasky.data.util.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class AuthenticationRepoImpl(
    private val authenticationApi: AuthenticationApi,
    private val authPreferences: AuthPreferences,
    private val dispatcher: CoroutineDispatcher
): AuthenticationRepo {
    override suspend fun signIn(signInUser: SignInUser): ApiResponse<SigninResponse> {
        return withContext(dispatcher) {
            try {
                val result = authenticationApi.signIn(signInUser, BuildConfig.X_API_KEY)
                ApiResponse.Success(result)
            } catch (e: Exception) {
                ApiResponse.Error("Fail")
            }

        }
    }

    override suspend fun register(registerUser: RegisterUser): ApiResponse<String> {
        return withContext(dispatcher) {
            try {
                authenticationApi.register(registerUser, BuildConfig.X_API_KEY)
                ApiResponse.Success("Success")
            } catch (e: Exception) {
                ApiResponse.Error("Fail")
            }

        }
    }

    override suspend fun getAuthToken(): String? = authPreferences.fetchToken()

}