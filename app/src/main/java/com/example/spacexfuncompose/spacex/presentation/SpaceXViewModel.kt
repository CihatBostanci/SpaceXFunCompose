package com.example.spacexfuncompose.spacex.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexfuncompose.model.AllRocketListResponse
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.spacex.data.SpaceXRepository
import com.example.spacexfuncompose.utils.IntentUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpaceXViewModel @Inject constructor(
    private val spaceXRepository: SpaceXRepository
) : ViewModel() {

    private var _rocketList: MutableLiveData<MutableList<AllRocketResponse>> = MutableLiveData()
    val rocketList: LiveData<MutableList<AllRocketResponse>> get() = _rocketList

    private val _isRocketProgress: MutableLiveData<Boolean> = MutableLiveData(false)
    val isRocketProgress: LiveData<Boolean> get() = _isRocketProgress

    fun getSpaceXRockets() = viewModelScope.launch {
        spaceXRepository.getSpaceXRockets().collect {
            _rocketList.postValue(
                IntentUtil.gson.fromJson(
                    it.charStream(), AllRocketListResponse::class.java
                )
            )
        }
    }


}
