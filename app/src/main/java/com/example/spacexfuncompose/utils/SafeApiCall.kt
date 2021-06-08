package com.example.spacexfuncompose.utils

suspend fun <T : Any> safeApiCall(apiCall: suspend () -> T): Resource<T> = try {
    val response = apiCall()
    Resource.Success(response)
} catch (ex: Exception) {
    Resource.DataError(ex)
}