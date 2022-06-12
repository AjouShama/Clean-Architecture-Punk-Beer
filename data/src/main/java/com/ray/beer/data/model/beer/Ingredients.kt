package com.ray.beer.data.model.beer

data class Ingredients(
    val hops: List<Any?>,
    val malt: List<Malt?>,
    val yeast: String?
)