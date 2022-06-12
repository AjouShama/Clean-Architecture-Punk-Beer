package com.ray.beer.domain.repository.beer

import com.ray.beer.domain.model.beer.PunkBeerPure
import com.ray.beer.domain.model.common.ResponseCover
import kotlinx.coroutines.flow.Flow

interface PunkBeerRepository {
    fun getRandomPunkBeer(): Flow<ResponseCover<PunkBeerPure>>
}