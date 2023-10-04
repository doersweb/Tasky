package com.doersweb.tasky.authentication.data.remote.repo

import com.doersweb.tasky.authentication.data.prefs.AuthPreferences
import com.doersweb.tasky.authentication.data.remote.AuthenticationApi
import com.doersweb.tasky.data.dto.UserRegistrationData
import com.doersweb.tasky.data.dto.SignInUser
import com.doersweb.tasky.data.remote.response.SigninResponse
import com.doersweb.tasky.data.util.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException

class AuthenticationRepoImpl(
    private val authenticationApi: AuthenticationApi,
    private val authPreferences: AuthPreferences,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthenticationRepo {
    override suspend fun signIn(signInUser: SignInUser): ApiResponse<SigninResponse> = try {
        val result = authenticationApi.signIn(signInUser)
        ApiResponse.Success(result)
    } catch (exception: Exception) {
        when (exception) {
            is HttpException -> ApiResponse.Error(exception.message())
            else -> throw exception
        }
    }

    override suspend fun register(userRegistrationData: UserRegistrationData): ApiResponse<String> =
        try {
            authenticationApi.register(userRegistrationData)
            ApiResponse.Success("Success")
        } catch (exception: Exception) {
            when (exception) {
                is HttpException -> ApiResponse.Error(exception.message())
                else -> throw exception
            }
        }

    override suspend fun getAuthToken(): String? = authPreferences.fetchToken()

}