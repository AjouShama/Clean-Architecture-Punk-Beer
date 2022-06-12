package com.ray.beer.domain.model.common

data class ResponseCover<T>(
    val isSuccess: Boolean,
    val statusCode: Int?,
    val data: T?
)