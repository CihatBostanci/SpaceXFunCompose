package com.example.spacexfuncompose.di

import com.example.spacexfuncompose.spacex.SpaceXService
import com.example.spacexfuncompose.spacex.data.SpaceXRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideSpaceXRepository(service: SpaceXService) = SpaceXRepository(service)

    /*@Provides
    @ActivityRetainedScoped
    fun provideSpaceXUseCase(repository: SpaceXRepository) = SpaceXUseCase(repository)
    */
}