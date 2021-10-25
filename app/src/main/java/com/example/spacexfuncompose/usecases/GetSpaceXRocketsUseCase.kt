package com.example.spacexfuncompose.usecases

import com.example.spacexfuncompose.base.BaseUseCase
import com.example.spacexfuncompose.base.BaseUseCaseRequest
import com.example.spacexfuncompose.feature.spacex.data.SpaceXRepository
import com.example.spacexfuncompose.model.AllRocketListResponse
import kotlinx.coroutines.flow.Flow

class GetSpaceXRocketsUseCase(
    private val repository: SpaceXRepository
) : BaseUseCase<BaseUseCaseRequest, AllRocketListResponse>() {

    override suspend fun buildUseCaseObservable(params: BaseUseCaseRequest)
            : Flow<AllRocketListResponse> = repository.getSpaceXRockets()

    class Request : BaseUseCaseRequest()
}