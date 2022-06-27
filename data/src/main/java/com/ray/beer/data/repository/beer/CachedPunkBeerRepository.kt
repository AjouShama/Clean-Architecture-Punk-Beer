package com.ray.beer.data.repository.beer

import com.ray.beer.domain.model.beer.PunkBeerPure
import com.ray.beer.domain.model.common.ResponseCover
import com.ray.beer.domain.repository.beer.PunkBeerRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CachedPunkBeerRepository @Inject constructor(
    private val punkBeerRepository: PunkBeerRepository
) : PunkBeerRepository {
    var cachedBeers = HashMap<String, PunkBeerPure>()

    override fun getRandomPunkBeer(): Flow<ResponseCover<PunkBeerPure>> {
        return punkBeerRepository.getRandomPunkBeer()
    }

    override fun getPunkBeerByName(name: String): Flow<ResponseCover<PunkBeerPure>> {
        return if (cachedBeers.containsKey(name)) {
            flow {
                emit(
                    ResponseCover(
                        isSuccess = true,
                        statusCode = 200,
                        data = cachedBeers[name]
                    )
                )
            }
        } else {
            flow {
                punkBeerRepository.getPunkBeerByName(name).collect() {
                    if (it.isSuccess) {
                        val data = it.data ?: return@collect
                        val key = data.name
                        cachedBeers[key] = data
                    }
                    emit(it)
                }
            }
        }
    }
}