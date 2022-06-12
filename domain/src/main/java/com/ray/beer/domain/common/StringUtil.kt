package com.ray.beer.domain.common

fun Char?.orEmpty(): Char {
    return this ?: Char.MIN_VALUE
}