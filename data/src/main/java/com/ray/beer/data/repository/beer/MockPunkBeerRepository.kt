package com.ray.beer.data.repository.beer

import com.ray.beer.domain.model.beer.PunkBeerPure
import com.ray.beer.domain.model.common.ResponseCover
import com.ray.beer.domain.repository.beer.PunkBeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockPunkBeerRepository : PunkBeerRepository {
    override fun getRandomPunkBeer(): Flow<ResponseCover<PunkBeerPure>> = flow {
        emit(
            ResponseCover(
                isSuccess = true,
                statusCode = 200,
                data = PunkBeerPure.mock
            )
        )
    }

    override fun getPunkBeerByName(name: String): Flow<ResponseCover<PunkBeerPure>> = flow {
        emit(
            ResponseCover(
                isSuccess = true,
                statusCode = 200,
                data = PunkBeerPure.mock
            )
        )
    }
}