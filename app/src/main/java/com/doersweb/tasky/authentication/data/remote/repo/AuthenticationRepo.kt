package com.doersweb.tasky.authentication.data.remote.repo

import com.doersweb.tasky.data.dto.UserRegistrationData
import com.doersweb.tasky.data.dto.SignInUser
import com.doersweb.tasky.data.remote.response.SigninResponse
import com.doersweb.tasky.data.util.ApiResponse

interface AuthenticationRepo {
    suspend fun signIn(signInUser: SignInUser): ApiResponse<SigninResponse>
    suspend fun register(userRegistrationData: UserRegistrationData) : ApiResponse<String>
    suspend fun getAuthToken(): String?
}