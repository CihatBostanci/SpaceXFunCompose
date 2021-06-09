package com.example.spacexfuncompose.spacex.data

import com.example.spacexfuncompose.spacex.SpaceXService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SpaceXRepository @Inject constructor(
    private val apiService: SpaceXService
) {
    suspend fun getSpaceXRockets() = flow {
        delay(1000)
        // Send a random fake weather forecast data
        emit(apiService.getAllRockets())
    }
}

