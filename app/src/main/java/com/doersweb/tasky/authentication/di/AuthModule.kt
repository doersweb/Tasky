package com.doersweb.tasky.authentication.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.os.BuildCompat
import com.doersweb.tasky.authentication.data.prefs.AuthPreferences
import com.doersweb.tasky.authentication.data.prefs.AuthPreferencesImpl
import com.doersweb.tasky.authentication.data.remote.AuthenticationApi
import com.doersweb.tasky.data.remote.repo.authentication.AuthenticationRepo
import com.doersweb.tasky.data.remote.repo.authentication.AuthenticationRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun providesPreferences(
        sharedPreferences: SharedPreferences
    ): AuthPreferences = AuthPreferencesImpl(sharedPreferences)

    @Provides
    @Singleton
    fun providesSharedPreferences(
        app: Application
    ): SharedPreferences = app.getSharedPreferences("auth_pref", MODE_PRIVATE)

    @Provides
    @Singleton
    fun providesAuthApi(
        okHttpClient: OkHttpClient
    ): AuthenticationApi = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create()

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()

    @Provides
    @Singleton
    fun providesAuthRepo(
        authenticationApi: AuthenticationApi,
        authPreferences: AuthPreferences
    ): AuthenticationRepo = AuthenticationRepoImpl(
        authenticationApi, authPreferences
    )

}