package com.ray.beer.app.di

import com.ray.beer.data.api.beer.PunkBeerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Singleton
    fun providePunkBeerApi(
        retrofit: Retrofit
    ): PunkBeerApi {
        return retrofit.create(PunkBeerApi::class.java)
    }
}