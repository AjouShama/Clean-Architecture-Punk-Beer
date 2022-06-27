package com.ray.beer.app.di

import com.ray.beer.app.BuildConfig
import com.ray.beer.core.di.CachedPunkBeer
import com.ray.beer.core.di.NonCachedPunkBeer
import com.ray.beer.data.api.beer.PunkBeerApi
import com.ray.beer.data.repository.beer.CachedPunkBeerRepository
import com.ray.beer.data.repository.beer.MockPunkBeerRepository
import com.ray.beer.data.repository.beer.RealPunkBeerRepository
import com.ray.beer.domain.repository.beer.PunkBeerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    @NonCachedPunkBeer
    fun providePunkBeerRepository(
        punkBeerApi: PunkBeerApi
    ): PunkBeerRepository {
        return if (BuildConfig.MOCK) {
            MockPunkBeerRepository()
        } else {
            RealPunkBeerRepository(punkBeerApi)
        }
    }

    @Provides
    @Singleton
    @CachedPunkBeer
    fun provideCachedPunkBeerRepository(
        @NonCachedPunkBeer punkBeerRepository: PunkBeerRepository
    ): PunkBeerRepository {
        return CachedPunkBeerRepository(punkBeerRepository)
    }
}