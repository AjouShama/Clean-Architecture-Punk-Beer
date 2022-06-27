package com.ray.beer.core.util

fun String.replaceSpaceToUnderscore(): String {
    return replace(' ', '_')
}