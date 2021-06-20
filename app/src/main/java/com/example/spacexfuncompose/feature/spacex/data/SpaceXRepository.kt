package com.example.spacexfuncompose.feature.spacex.data

import com.example.spacexfuncompose.feature.spacex.SpaceXService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SpaceXRepository @Inject constructor(
    private val apiService: SpaceXService,
    private val favoriteRocketDAO: FavoriteRocketDAO
) {
    suspend fun getSpaceXRockets() = flow {
        delay(3000)
        // Send a random fake weather forecast data
        emit(
            //IntentUtil.gson.fromJson(
            apiService.getAllRockets()//.charStream(), AllRocketListResponse::class.java
            //)
        )
    }

    fun addRocketFavoriteList(rocketId: String) {
        favoriteRocketDAO.insertRocket(rocketId)
    }

    fun deleteRocketFavoriteList(rocketId: String) {
        favoriteRocketDAO.deleteRocket(rocketId)
    }

    fun getFavoriteRockets() = favoriteRocketDAO.getAllRockets()

}

