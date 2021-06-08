package com.example.spacexfuncompose.spacex.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexfuncompose.model.AllRocketsResponseItem
import com.example.spacexfuncompose.spacex.domain.SpaceXUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpaceXViewModel @Inject constructor(
    private val spaceXUseCase: SpaceXUseCase
) : ViewModel() {

    private var _rocketList: MutableLiveData<List<AllRocketsResponseItem>> = MutableLiveData()
    val rocketList: LiveData<List<AllRocketsResponseItem>> get() = _rocketList

    private val _isRocketProgress: MutableLiveData<Boolean> = MutableLiveData(false)
    val isRocketProgress: LiveData<Boolean> get() = _isRocketProgress

    fun getSpaceXRockets() = viewModelScope.launch {
        spaceXUseCase.invoke()
            .onStart { _isRocketProgress.postValue(true) }
            .onCompletion { _isRocketProgress.postValue(false) }
            .catch { _isRocketProgress.postValue(false) }
            .collect { _rocketList.postValue(it) }


    }


}
