package com.doersweb.tasky.authentication.data.prefs

import android.content.SharedPreferences

class AuthPreferencesImpl(
    private val sharedPreferences: SharedPreferences
): AuthPreferences {
    override fun saveToken(token: String) {
        sharedPreferences.edit()
            .putString(AUTH_TOKEN, token)
            .apply()
    }

    override fun fetchToken(): String? {
        return sharedPreferences.getString(AUTH_TOKEN, null)
    }

    companion object {
        const val AUTH_TOKEN = "AUTH_TOKEN"
    }
}