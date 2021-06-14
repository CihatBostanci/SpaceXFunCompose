package com.example.spacexfuncompose.feature.spacexdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class SpaceXDetailViewModel @Inject constructor(
    private val spaceXUseCase: SpaceXUseCase,
    private val navigationManager: NavigationManager
) : ViewModel() {

    private var _rocket: MutableLiveData<AllRocketResponse> = MutableLiveData()
    val rocket: LiveData<AllRocketResponse> get() = _rocket

    fun loadRocket(){
        if(navigationManager.bundle.getParcelable<AllRocketResponse>("selected_person") != null) {
            _rocket.postValue(navigationManager.bundle.getParcelable("selected_person")!!)
        }
    }

}