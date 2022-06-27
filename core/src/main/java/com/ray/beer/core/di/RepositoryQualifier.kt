package com.ray.beer.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class NonCachedPunkBeer

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CachedPunkBeer