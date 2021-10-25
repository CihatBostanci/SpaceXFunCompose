package com.example.spacexfuncompose.usecases

import com.example.spacexfuncompose.base.BaseUseCase
import com.example.spacexfuncompose.base.BaseUseCaseRequest
import com.example.spacexfuncompose.feature.spacex.data.SpaceXRepository
import kotlinx.coroutines.flow.Flow

class AddRocketToFavoriteUseCase(
    private val repository: SpaceXRepository
) : BaseUseCase<AddRocketToFavoriteUseCase.Request, Unit>() {

    override suspend fun buildUseCaseObservable(params: Request) =
        repository.addRocketFavoriteList(params.rocketId)

    data class Request(
        val rocketId: String
    ): BaseUseCaseRequest()
}