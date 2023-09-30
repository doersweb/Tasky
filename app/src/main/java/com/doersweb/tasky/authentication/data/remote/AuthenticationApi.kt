package com.doersweb.tasky.authentication.data.remote

import com.doersweb.tasky.data.remote.response.SigninResponse
import com.doersweb.tasky.data.dto.RegisterUser
import com.doersweb.tasky.data.dto.SignInUser
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("/register")
    @Headers("Accept: application/json")
    suspend fun register(
        @Body registerUser: RegisterUser,
        @Header("x-api-key") apiKey: String
    )

    @POST("/login")
    @Headers("Accept: application/json")
    suspend fun signIn(
        @Body signInUser: SignInUser,
        @Header("x-api-key") apiKey: String
    ): SigninResponse
}