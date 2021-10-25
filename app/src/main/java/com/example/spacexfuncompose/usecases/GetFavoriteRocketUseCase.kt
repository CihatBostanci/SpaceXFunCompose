package com.example.spacexfuncompose.usecases

import com.example.spacexfuncompose.base.BaseUseCase
import com.example.spacexfuncompose.base.BaseUseCaseRequest
import com.example.spacexfuncompose.feature.spacex.data.SpaceXRepository
import com.example.spacexfuncompose.model.FavoriteIdEntity


class GetFavoriteRocketUseCase(
    private val repository: SpaceXRepository
) : BaseUseCase<BaseUseCaseRequest, MutableList<FavoriteIdEntity>>() {

    override suspend fun buildUseCaseObservable(params: BaseUseCaseRequest) = repository.getFavoriteRockets()

     class Request : BaseUseCaseRequest()
}