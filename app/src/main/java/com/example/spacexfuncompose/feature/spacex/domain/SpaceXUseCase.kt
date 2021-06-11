package com.example.spacexfuncompose.feature.spacex.domain

import com.example.spacexfuncompose.feature.spacex.data.SpaceXRepository
import kotlinx.coroutines.flow.map

class SpaceXUseCase(private val repository: SpaceXRepository) {
    suspend operator fun invoke() = repository.getSpaceXRockets()
}