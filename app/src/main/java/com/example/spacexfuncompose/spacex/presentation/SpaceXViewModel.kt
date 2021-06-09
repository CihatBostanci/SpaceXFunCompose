package com.example.spacexfuncompose.spacex.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexfuncompose.model.AllRocketListResponse
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.spacex.data.SpaceXRepository
import com.example.spacexfuncompose.spacex.domain.SpaceXUseCase
import kotlinx.coroutines.flow.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpaceXViewModel @Inject constructor(
    private val spaceXUseCase: SpaceXUseCase
) : ViewModel() {

    private var _rocketList: MutableLiveData<MutableList<AllRocketResponse>> = MutableLiveData()
    val rocketList: LiveData<MutableList<AllRocketResponse>> get() = _rocketList

    private val _isRocketProgress: MutableLiveData<Boolean> = MutableLiveData(false)
    val isRocketProgress: LiveData<Boolean> get() = _isRocketProgress

    @InternalCoroutinesApi
    fun getSpaceXRockets() = viewModelScope.launch {
        spaceXUseCase.invoke()
            .onStart { _isRocketProgress.postValue(true) }
            .onCompletion { _isRocketProgress.postValue(false) }
            .catch { _isRocketProgress.postValue(false) }
            .collect { _rocketList.postValue(it)}
        /*spaceXRepository.getSpaceXRockets().collect {
            _rocketList.postValue(
                IntentUtil.gson.fromJson(
                    it.charStream(), AllRocketListResponse::class.java
                )
            )
        }*/
    }


}
