package com.example.spacexfuncompose.feature.spacex.data

import com.example.spacexfuncompose.feature.spacex.SpaceXService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SpaceXRepository @Inject constructor(
    private val apiService: SpaceXService,
    private val favoriteRocketDAO: FavoriteRocketDAO
) {
    companion object {
        const val DELAY_FOR_FAVORITE = 1000L
    }
    suspend fun getSpaceXRockets() = flow {

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

   suspend fun getFavoriteRockets() = flow {
       delay(DELAY_FOR_FAVORITE)
        // Send a random fake weather forecast data
        emit(
            favoriteRocketDAO.getAllRockets()
        )
    }

}

