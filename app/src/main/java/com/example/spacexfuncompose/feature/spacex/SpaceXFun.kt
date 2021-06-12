package com.example.spacexfuncompose

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import com.example.spacexfuncompose.component.SpaceXFunItem
import com.example.spacexfuncompose.customcomponent.ProgressLoadingIndicator
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.feature.spacex.presentation.SpaceXViewModel
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@Composable
fun SpaceXFun( viewModel: SpaceXViewModel) {

    val itemList: List<AllRocketResponse> by viewModel.rocketList.observeAsState(listOf())
    val loading = viewModel.isRocketProgress.value

    Row(modifier = Modifier.fillMaxSize()) {
        Log.d("SpaceXFUN", "on run")
        LazyRow {
            items(itemList) { item ->

                SpaceXFunItem(item)
            }
        }
         //ProgressLoadingIndicator(isDisplayed = loading)
    }
}

