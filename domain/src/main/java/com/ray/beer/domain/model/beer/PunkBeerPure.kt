package com.ray.beer.domain.model.beer

data class PunkBeerPure(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String
) {
    companion object {
        val mock = PunkBeerPure(
            id = 192,
            name = "Punk IPA 2007 - 2010",
            tagline = "Post Modern Classic. Spiky. Tropical. Hoppy.",
            description = "Our flagship beer that kick started the craft beer revolution. This is James and Martin's original take on an American IPA, subverted with punchy New Zealand hops. Layered with new world hops to create an all-out riot of grapefruit, pineapple and lychee before a spiky, mouth-puckering bitter finish."
        )
    }
}