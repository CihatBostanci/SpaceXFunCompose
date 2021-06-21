package com.example.spacexfuncompose.feature.spacexdetail.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import com.example.spacexfuncompose.feature.spacex.presentation.SpaceXViewModel
import com.example.spacexfuncompose.model.FavoriteIdEntity
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
class SpaceXDetailViewModel @Inject constructor(
    private val spaceXUseCase: SpaceXUseCase,
    private val navigationManager: NavigationManager
) : ViewModel() {

    companion object {
        private const val TAG = "SpaceXDetailViewModel"
    }

    private var _favoriteRocketList: MutableLiveData<MutableList<FavoriteIdEntity>> = MutableLiveData()
    val favoriteRocketListLiveData: LiveData<MutableList<FavoriteIdEntity>> get() = _favoriteRocketList

    init {
        getFavoriteRocketList()
    }

    fun addRocketToFavorite(rocketId: String) = viewModelScope.launch(Dispatchers.IO) {
        spaceXUseCase.addRocketToFavorite(rocketId)
    }

    fun deleteRocketToFavorite(rocketId: String) = viewModelScope.launch(Dispatchers.IO) {
        spaceXUseCase.deleteRocketToFavorite(rocketId)
    }

    private fun getFavoriteRocketList() = viewModelScope.launch(Dispatchers.IO) {
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

}