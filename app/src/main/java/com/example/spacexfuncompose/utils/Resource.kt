package com.example.spacexfuncompose.utils

sealed class Resource<T>(
    val data: T? = null,
    val error: Exception? = null
) {
    class Success<T : Any>(data: T?) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class DataError<T>(error: Exception) : Resource<T>(null, error)
}
