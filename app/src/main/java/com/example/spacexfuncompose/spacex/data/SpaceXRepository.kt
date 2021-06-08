package com.example.spacexfuncompose.spacex.data

import com.example.spacexfuncompose.model.AllRocketsResponseItem
import com.example.spacexfuncompose.spacex.SpaceXService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SpaceXRepository @Inject constructor(
    private val apiService: SpaceXService
) {
    suspend fun getSpaceXRockets(): Flow<MutableList<AllRocketsResponseItem>> =
        apiService.getAllRockets().flowOn(Dispatchers.IO)
}

