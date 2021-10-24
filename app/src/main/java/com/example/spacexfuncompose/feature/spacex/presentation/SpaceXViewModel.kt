package com.example.spacexfuncompose.feature.spacex.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.model.FavoriteIdEntity
import com.example.spacexfuncompose.navigation.NavigationDirections
import com.example.spacexfuncompose.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class SpaceXViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val spaceXUseCase: SpaceXUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "SpaceXViewModel"
    }

    private var _rocketList: MutableLiveData<MutableList<AllRocketResponse>> = MutableLiveData()
    val rocketList: LiveData<MutableList<AllRocketResponse>> get() = _rocketList

    private val _isRocketProgress: MutableLiveData<Boolean> = MutableLiveData(true)
    val isRocketProgress: LiveData<Boolean> get() = _isRocketProgress

    private var _favoriteRocketList: MutableLiveData<MutableList<FavoriteIdEntity>> =
        MutableLiveData()
    val favoriteRocketListLiveData: LiveData<MutableList<FavoriteIdEntity>> get() = _favoriteRocketList

    init {
        getSpaceXRockets()
        getFavoriteRocketList()
    }

    fun getFavoriteRocketList() = viewModelScope.launch(Dispatchers.IO) {
        spaceXUseCase.getFavoriteRockets()
            .onStart {
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
    private fun getSpaceXRockets() = viewModelScope.launch(Dispatchers.IO) {
        spaceXUseCase.invoke()
            .onStart {
                Log.d(TAG, "On start")
                _isRocketProgress.postValue(true)
            }
            .onCompletion {
                Log.d(TAG, "On Completion")
                _isRocketProgress.postValue(false)
            }
            .catch {
                Log.d(TAG, "On Error")
                _isRocketProgress.postValue(false)
            }
            .collect {
                Log.d(TAG, "On Collect")
                _rocketList.postValue(it)
            }
    }

    fun goToDetail(spaceXViewItem: AllRocketResponse) {
        Log.d(TAG, "Go To Detail")
        navigationManager.navigate(
            NavigationDirections.SpaceXDetail.also {
                it.arguments.apply {
                    putParcelable("rocket", spaceXViewItem)
                }
            }
        )
    }

    fun addRocketToFavorite(rocketId: String) = viewModelScope.launch(Dispatchers.IO) {
        spaceXUseCase.addRocketToFavorite(rocketId)
    }

    fun deleteRocketToFavorite(rocketId: String) = viewModelScope.launch(Dispatchers.IO) {
        spaceXUseCase.deleteRocketToFavorite(rocketId)
    }
}
