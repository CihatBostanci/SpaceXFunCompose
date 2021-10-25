package com.example.spacexfuncompose.di

import com.example.spacexfuncompose.feature.spacex.SpaceXService
import com.example.spacexfuncompose.feature.spacex.data.FavoriteRocketDAO
import com.example.spacexfuncompose.feature.spacex.data.SpaceXRepository
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import com.example.spacexfuncompose.usecases.AddRocketToFavoriteUseCase
import com.example.spacexfuncompose.usecases.DeleteRocketToFavoriteUseCase
import com.example.spacexfuncompose.usecases.GetFavoriteRocketUseCase
import com.example.spacexfuncompose.usecases.GetSpaceXRocketsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideSpaceXRepository(
        service: SpaceXService,
        favoriteRocketDAO: FavoriteRocketDAO
    ) = SpaceXRepository(service, favoriteRocketDAO)

    @Provides
    @ActivityRetainedScoped
    fun provideGetSpaceXRocketUseCase(repository: SpaceXRepository) =
        GetSpaceXRocketsUseCase(repository = repository)

    @Provides
    @ActivityRetainedScoped
    fun provideGetFavoriteRocketUseCase(repository: SpaceXRepository) =
        GetFavoriteRocketUseCase(repository = repository)

    @Provides
    @ActivityRetainedScoped
    fun provideDeleteRocketToFavoriteUseCase(repository: SpaceXRepository) =
        DeleteRocketToFavoriteUseCase(repository = repository)

    @Provides
    @ActivityRetainedScoped
    fun provideAddRocketToFavoriteUseCase(repository: SpaceXRepository) =
        AddRocketToFavoriteUseCase(repository = repository)

    @Provides
    @ActivityRetainedScoped
    fun provideSpaceXUseCase(
        getSpaceXRocketsUseCase: GetSpaceXRocketsUseCase,
        getFavoriteRocketUseCase: GetFavoriteRocketUseCase,
        addRocketToFavoriteUseCase: AddRocketToFavoriteUseCase,
        deleteRocketToFavoriteUseCase: DeleteRocketToFavoriteUseCase
    ) = SpaceXUseCase(
        addRocketToFavoriteUseCase = addRocketToFavoriteUseCase,
        getSpaceXRocketsUseCase = getSpaceXRocketsUseCase,
        getFavoriteRocketUseCase = getFavoriteRocketUseCase,
        deleteRocketToFavoriteUseCase = deleteRocketToFavoriteUseCase
    )

}