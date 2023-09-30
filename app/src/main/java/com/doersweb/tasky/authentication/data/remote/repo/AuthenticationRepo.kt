package com.doersweb.tasky.data.remote.repo.authentication

interface AuthenticationRepo {
    suspend fun signIn()
    suspend fun register()
    suspend fun getAuthToken()
}