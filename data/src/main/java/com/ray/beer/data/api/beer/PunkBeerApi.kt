package com.ray.beer.data.api.beer

import com.ray.beer.data.model.beer.PunkBeerRes
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface PunkBeerApi {
    @GET("/v2/beers/random")
    fun getRandomPunkBeer(): ApiResponse<PunkBeerRes>
}