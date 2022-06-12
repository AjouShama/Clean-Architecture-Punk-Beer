package com.ray.beer.domain.usecase.beer

import com.ray.beer.domain.model.beer.PunkBeerPure
import com.ray.beer.domain.model.common.ResponseCover
import com.ray.beer.domain.repository.beer.PunkBeerRepository
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

@Reusable
class GetRandomPunkBeer @Inject constructor(
    private val punkBeerRepository: PunkBeerRepository
) {
    operator fun invoke(): Flow<ResponseCover<PunkBeerPure>> {
        return punkBeerRepository.getRandomPunkBeer()
            .flowOn(Dispatchers.IO)
    }
}