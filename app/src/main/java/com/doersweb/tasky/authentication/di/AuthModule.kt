package com.doersweb.tasky.authentication.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.doersweb.calorietracker.BuildConfig
import com.doersweb.tasky.authentication.data.prefs.AuthPreferences
import com.doersweb.tasky.authentication.data.prefs.AuthPreferencesImpl
import com.doersweb.tasky.authentication.data.remote.AuthenticationApi
import com.doersweb.tasky.authentication.data.remote.repo.AuthenticationRepo
import com.doersweb.tasky.authentication.data.remote.repo.AuthenticationRepoImpl
import com.doersweb.tasky.data.util.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create()

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ApiKeyInterceptor(BuildConfig.X_API_KEY)).build()

    @Provides
    @Singleton
    fun providesAuthRepo(
        authenticationApi: AuthenticationApi,
        authPreferences: AuthPreferences,
        dispatcher: CoroutineDispatcher
    ): AuthenticationRepo = AuthenticationRepoImpl(
        authenticationApi, authPreferences, dispatcher
    )

    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

}