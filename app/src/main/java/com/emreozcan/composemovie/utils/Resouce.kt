package com.emreozcan.composemovie.utils

/**
 * Created by @Emre Özcan on 27.05.2024
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data = data, message = message)
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
}