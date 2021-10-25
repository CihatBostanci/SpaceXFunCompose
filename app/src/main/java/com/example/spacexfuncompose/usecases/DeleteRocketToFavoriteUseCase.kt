package com.example.spacexfuncompose.usecases

import com.example.spacexfuncompose.base.BaseUseCase
import com.example.spacexfuncompose.base.BaseUseCaseRequest
import com.example.spacexfuncompose.feature.spacex.data.SpaceXRepository


class DeleteRocketToFavoriteUseCase(
    private val repository: SpaceXRepository
) : BaseUseCase<DeleteRocketToFavoriteUseCase.Request, Unit>() {

    override suspend fun buildUseCaseObservable(params: Request) =
        repository.deleteRocketFavoriteList(params.rocketId)

    data class Request(
        val rocketId: String
    ) : BaseUseCaseRequest()
}