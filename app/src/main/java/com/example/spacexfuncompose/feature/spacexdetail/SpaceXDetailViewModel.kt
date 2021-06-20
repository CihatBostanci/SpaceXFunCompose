package com.example.spacexfuncompose.feature.spacexdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class SpaceXDetailViewModel @Inject constructor(
    private val spaceXUseCase: SpaceXUseCase,
    private val navigationManager: NavigationManager
) : ViewModel() {

    fun addRocketToFavorite(rocketId: String) = viewModelScope.launch(Dispatchers.IO) {
        spaceXUseCase.addRocketToFavorite(rocketId)
    }

    fun deleteRocketToFavorite(rocketId: String) = viewModelScope.launch(Dispatchers.IO) {
        spaceXUseCase.deleteRocketToFavorite(rocketId)
    }

}