package com.ray.beer.data.api.beer

import com.ray.beer.data.model.beer.PunkBeerRes
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PunkBeerApi {
    @GET("/v2/beers/random")
    suspend fun getRandomPunkBeer(): ApiResponse<List<PunkBeerRes>>

    @GET("/v2/beers")
    suspend fun getPunkBeerByName(
        @Query("beer_name") name: String
    ): ApiResponse<List<PunkBeerRes>>
}