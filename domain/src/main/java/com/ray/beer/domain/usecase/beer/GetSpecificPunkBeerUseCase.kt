package com.ray.beer.domain.usecase.beer

import com.ray.beer.core.di.CachedPunkBeer
import com.ray.beer.domain.model.beer.PunkBeerPure
import com.ray.beer.domain.model.common.ResponseCover
import com.ray.beer.domain.repository.beer.PunkBeerRepository
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

@Reusable
class GetSpecificPunkBeerUseCase @Inject constructor(
    @CachedPunkBeer private val punkBeerRepository: PunkBeerRepository
) {
    operator fun invoke(name: String): Flow<ResponseCover<PunkBeerPure>> {
        return punkBeerRepository.getPunkBeerByName(name)
            .flowOn(Dispatchers.IO)
    }
}