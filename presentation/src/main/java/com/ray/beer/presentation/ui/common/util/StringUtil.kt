package com.ray.beer.presentation.ui.common.util

fun Char?.orEmpty(): Char {
    return this ?: Char.MIN_VALUE
}