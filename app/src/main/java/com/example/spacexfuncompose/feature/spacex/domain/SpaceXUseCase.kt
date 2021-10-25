package com.example.spacexfuncompose.feature.spacex.domain

import com.example.spacexfuncompose.usecases.AddRocketToFavoriteUseCase
import com.example.spacexfuncompose.usecases.DeleteRocketToFavoriteUseCase
import com.example.spacexfuncompose.usecases.GetFavoriteRocketUseCase
import com.example.spacexfuncompose.usecases.GetSpaceXRocketsUseCase

class SpaceXUseCase(
    val addRocketToFavoriteUseCase: AddRocketToFavoriteUseCase,
    val getSpaceXRocketsUseCase: GetSpaceXRocketsUseCase,
    val getFavoriteRocketUseCase: GetFavoriteRocketUseCase,
    val deleteRocketToFavoriteUseCase: DeleteRocketToFavoriteUseCase
)
