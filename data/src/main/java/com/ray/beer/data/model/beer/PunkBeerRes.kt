package com.ray.beer.data.model.beer

data class PunkBeerRes(
    val id: Int?,
    val name: String?,
    val tagline: String?,
    val description: String?,
    val image_url: String?,
    val abv: Double?,
    val attenuation_level: Double?,
    val boil_volume: BoilVolume?,
    val brewers_tips: String?,
    val contributed_by: String?,
    val ebc: Double?,
    val first_brewed: String?,
    val food_pairing: List<String?>,
    val ibu: Double?,
    val ingredients: Ingredients?,
    val method: Method?,
    val ph: Double?,
    val srm: Double?,
    val target_fg: Double?,
    val target_og: Double?,
    val volume: Volume?
)