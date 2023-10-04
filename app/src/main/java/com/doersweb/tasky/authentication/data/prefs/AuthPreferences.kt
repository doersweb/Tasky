package com.doersweb.tasky.authentication.data.prefs

interface AuthPreferences {
    fun saveToken(token: String)
    fun fetchToken(): String?
}