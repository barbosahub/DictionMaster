package com.codeplace.dictionary.di

import com.codeplace.dictionary.data.remote.API
import com.codeplace.dictionary.data.remote.API.Companion.BASE_URL
import com.codeplace.dictionary.data.remote.repository.NetworkRepositoryImpl
import com.codeplace.dictionary.domain.repository.NetworkRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun providesRetrofit(moshi: Moshi): API {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(API::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(api: API): NetworkRepository {
        return NetworkRepositoryImpl(api = api)
    }
}