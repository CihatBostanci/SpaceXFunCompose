package com.example.spacexfuncompose.feature.spacexdetail

import androidx.lifecycle.ViewModel
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class SpaceXDetailViewModel @Inject constructor(
    private val spaceXUseCase: SpaceXUseCase
) : ViewModel() {


}