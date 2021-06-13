package com.example.spacexfuncompose.feature.spacex.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.navigation.NavigationDirections
import com.example.spacexfuncompose.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val spaceXUseCase: SpaceXUseCase,
    private val navigationManager: NavigationManager
) : ViewModel() {
    companion object {
        private const val TAG = "SpaceXViewModel"
    }

    private var _rocketList: MutableLiveData<MutableList<AllRocketResponse>> = MutableLiveData()
    val rocketList: LiveData<MutableList<AllRocketResponse>> get() = _rocketList

    private val _isRocketProgress: MutableLiveData<Boolean> = MutableLiveData(true)
    val isRocketProgress: LiveData<Boolean> get() = _isRocketProgress

    init {
        getSpaceXRockets()
    }

    //Api Call
    private fun getSpaceXRockets() = viewModelScope.launch {
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

    fun goToDetail() {
        Log.d(TAG, "Go To Detail")
        navigationManager.navigate(NavigationDirections.SpaceXDetail)
    }

}
