package com.example.spacexfuncompose.feature.spacex.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spacexfuncompose.base.BaseViewModel
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.model.FavoriteIdEntity
import com.example.spacexfuncompose.navigation.NavigationDirections
import com.example.spacexfuncompose.navigation.NavigationManager
import com.example.spacexfuncompose.usecases.AddRocketToFavoriteUseCase
import com.example.spacexfuncompose.usecases.DeleteRocketToFavoriteUseCase
import com.example.spacexfuncompose.usecases.GetFavoriteRocketUseCase
import com.example.spacexfuncompose.usecases.GetSpaceXRocketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class SpaceXViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val spaceXUseCase: SpaceXUseCase
) : BaseViewModel() {

    companion object {
        private const val TAG = "SpaceXViewModel"
    }

    private var _rocketList: MutableLiveData<MutableList<AllRocketResponse>> = MutableLiveData()
    val rocketList: LiveData<MutableList<AllRocketResponse>> get() = _rocketList

    private var _favoriteRocketList: MutableLiveData<MutableList<FavoriteIdEntity>> =
        MutableLiveData()
    val favoriteRocketListLiveData: LiveData<MutableList<FavoriteIdEntity>> get() = _favoriteRocketList


    private var _addToFavorite: MutableLiveData<Unit> = MutableLiveData()
    val addToFavorite: LiveData<Unit> get() = _addToFavorite

    private var _deleteToFavorite: MutableLiveData<Unit> = MutableLiveData()
    val deleteToFavorite: LiveData<Unit> get() = _deleteToFavorite

    init {
        getSpaceXRockets()
    }

    fun getFavoriteRocketList() = launchDataLoad {

        spaceXUseCase.getFavoriteRocketUseCase.execute(
            GetFavoriteRocketUseCase.Request()
        ).onStart {
            Log.d(TAG, "On start favorite")
        }
            .onCompletion {
                Log.d(TAG, "On Completion favorite")
            }
            .catch {
                Log.d(TAG, "On Error favorite")
            }
            .collect {
                Log.d(TAG, "On Collect favorite")
                _favoriteRocketList.postValue(it)
            }
    }

    // Api Call
    private fun getSpaceXRockets() = launchDataLoad {
        spaceXUseCase.getSpaceXRocketsUseCase.execute(GetSpaceXRocketsUseCase.Request())
            .onStart {
                Log.d(TAG, "On start")
            }
            .onCompletion {
                Log.d(TAG, "On Completion")
            }
            .catch {
                Log.d(TAG, "On Error")
            }
            .collect {
                Log.d(TAG, "On Collect")
                _rocketList.postValue(it)
            }
    }

    fun goToDetail(spaceXViewItem: AllRocketResponse, isFavorite: Boolean) {
        Log.d(TAG, "Go To Detail")
        navigationManager.navigate(
            NavigationDirections.SpaceXDetail.also {
                it.arguments.apply {
                    putParcelable("rocket", spaceXViewItem)
                    putBoolean("isFavorite", isFavorite)
                }
            }
        )
    }

    fun addRocketToFavorite(rocketId: String) = launchDataLoad {
        spaceXUseCase.addRocketToFavoriteUseCase.execute(AddRocketToFavoriteUseCase.Request(rocketId = rocketId))
            .onStart {
                Log.d(TAG, "On start")
            }
            .onCompletion {
                Log.d(TAG, "On Completion")
            }
            .catch {
                Log.d(TAG, "On Error")
            }
            .collect {
                Log.d(TAG, "On Collect")
                _addToFavorite.postValue(it)
            }
    }

    fun deleteRocketToFavorite(rocketId: String) = launchDataLoad {
        spaceXUseCase.deleteRocketToFavoriteUseCase.execute(
            DeleteRocketToFavoriteUseCase.Request(
                rocketId = rocketId
            )
        )
            .onStart {
                Log.d(TAG, "On start")
            }
            .onCompletion {
                Log.d(TAG, "On Completion")
            }
            .catch {
                Log.d(TAG, "On Error")
            }
            .collect {
                Log.d(TAG, "On Collect")
                _deleteToFavorite.postValue(it)
            }
    }

}
