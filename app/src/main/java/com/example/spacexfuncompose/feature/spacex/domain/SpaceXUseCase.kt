package com.example.spacexfuncompose.feature.spacex.domain

import com.example.spacexfuncompose.feature.spacex.data.SpaceXRepository

class SpaceXUseCase(private val repository: SpaceXRepository) {

    suspend operator fun invoke() = repository.getSpaceXRockets()

    fun addRocketToFavorite(rocketId: String) = repository.addRocketFavoriteList(rocketId)

    suspend fun getFavoriteRockets() = repository.getFavoriteRockets()

    fun deleteRocketToFavorite(rocketId: String) = repository.deleteRocketFavoriteList(rocketId)

}