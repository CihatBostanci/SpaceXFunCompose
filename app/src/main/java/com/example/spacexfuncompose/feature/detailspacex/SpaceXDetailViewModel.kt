package com.example.spacexfuncompose.feature.detailspacex

import android.util.Log
import com.example.spacexfuncompose.base.BaseViewModel
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import com.example.spacexfuncompose.navigation.NavigationDirections
import com.example.spacexfuncompose.navigation.NavigationManager
import com.example.spacexfuncompose.usecases.AddRocketToFavoriteUseCase
import com.example.spacexfuncompose.usecases.DeleteRocketToFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class SpaceXDetailViewModel @Inject constructor(
    private val spaceXUseCase: SpaceXUseCase,
    private val navigationManager: NavigationManager
) : BaseViewModel() {

    companion object {
        private const val TAG = "SpaceXDetailViewModel"
    }

    fun addRocketToFavorite(rocketId: String) = launchDataLoad {
        spaceXUseCase.addRocketToFavoriteUseCase.execute(AddRocketToFavoriteUseCase.Request(rocketId))
            .onStart {

                Log.d(TAG, "On start favorite create")
            }
            .onCompletion {
                Log.d(TAG, "On Completion favorite create")
            }
            .catch {
                Log.d(TAG, "On Error favorite create")
            }
            .collect {
                Log.d("Cihat Log:", " favorite create:$rocketId")
            }
    }

    fun deleteRocketToFavorite(rocketId: String) = launchDataLoad {
        spaceXUseCase.deleteRocketToFavoriteUseCase.execute(
            DeleteRocketToFavoriteUseCase.Request(
                rocketId
            )
        ).onStart {
            Log.d(TAG, "On start favorite create")
        }
            .onCompletion {
                Log.d(TAG, "On Completion favorite create")
            }
            .catch {
                Log.d(TAG, "On Error favorite create")
            }
            .collect {
                Log.d(TAG, " favorite deleted:$rocketId")
            }
    }

    fun navigateSpaceX() {
        navigationManager.navigate(NavigationDirections.SpaceX)
    }

}
