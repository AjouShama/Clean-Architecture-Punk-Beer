package com.ray.beer.data.repository.beer

import com.ray.beer.data.api.beer.PunkBeerApi
import com.ray.beer.data.converter.beer.PunkBeerDataConverter
import com.ray.beer.domain.model.beer.PunkBeerPure
import com.ray.beer.domain.model.common.ResponseCover
import com.ray.beer.domain.repository.beer.PunkBeerRepository
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RealPunkBeerRepository @Inject constructor(
    private val punkBeerApi: PunkBeerApi
) : PunkBeerRepository {
    override fun getRandomPunkBeer(): Flow<ResponseCover<PunkBeerPure>> = flow {
        punkBeerApi.getRandomPunkBeer().suspendOnSuccess {
            emit(
                ResponseCover(
                    isSuccess = true,
                    statusCode = statusCode.code,
                    data = PunkBeerDataConverter.convertDataToDomain(data)
                )
            )
        }.suspendOnError {
            emit(
                ResponseCover(
                    isSuccess = false,
                    statusCode = statusCode.code,
                    data = null
                )
            )
        }.suspendOnException {
            emit(
                ResponseCover(
                    isSuccess = false,
                    statusCode = null,
                    data = null
                )
            )
        }
    }
}