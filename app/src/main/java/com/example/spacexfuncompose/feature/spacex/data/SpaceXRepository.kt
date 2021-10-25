package com.example.spacexfuncompose.feature.spacex.data

import com.example.spacexfuncompose.feature.spacex.SpaceXService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SpaceXRepository @Inject constructor(
    private val apiService: SpaceXService,
    private val favoriteRocketDAO: FavoriteRocketDAO
) {
    suspend fun getSpaceXRockets() = flow {
        emit(apiService.getAllRockets())
    }

    suspend fun addRocketFavoriteList(rocketId: String) = flow {
        emit(favoriteRocketDAO.insertRocket(rocketId))
    }

    suspend fun deleteRocketFavoriteList(rocketId: String) = flow {
        emit(favoriteRocketDAO.deleteRocket(rocketId))
    }

    suspend fun getFavoriteRockets() = flow {
        emit(favoriteRocketDAO.getAllRockets())
    }
}
