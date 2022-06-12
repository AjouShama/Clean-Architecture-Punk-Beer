package com.ray.beer.data.converter.beer

import com.ray.beer.data.model.beer.PunkBeerRes
import com.ray.beer.domain.model.beer.PunkBeerPure

object PunkBeerDataConverter {
    fun convertDataToDomain(punkBeer: PunkBeerRes): PunkBeerPure {
        return PunkBeerPure(
            id = punkBeer.id,
            name = punkBeer.name,
            tagline = punkBeer.tagline,
            description = punkBeer.description,
            imageUrl = punkBeer.image_url
        )
    }
}