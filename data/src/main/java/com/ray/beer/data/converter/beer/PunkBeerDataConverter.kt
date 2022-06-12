package com.ray.beer.data.converter.beer

import com.ray.beer.data.model.beer.PunkBeerRes
import com.ray.beer.domain.common.orZero
import com.ray.beer.domain.model.beer.PunkBeerPure

object PunkBeerDataConverter {
    fun convertDataToDomain(punkBeer: PunkBeerRes): PunkBeerPure {
        return PunkBeerPure(
            id = punkBeer.id.orZero(),
            name = punkBeer.name.orEmpty(),
            tagline = punkBeer.tagline.orEmpty(),
            description = punkBeer.description.orEmpty(),
            imageUrl = punkBeer.image_url.orEmpty()
        )
    }
}