package com.example.spacexfuncompose.feature.spacex.presentation

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.spacexfuncompose.customcomponent.ProgressLoadingIndicator
import com.example.spacexfuncompose.model.AllRocketResponse
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@Composable
fun SpaceXFun(viewModel: SpaceXViewModel) {

    val itemList: List<AllRocketResponse> by viewModel.rocketList.observeAsState(listOf())
    val loading = viewModel.isRocketProgress.value

    Row(modifier = Modifier.fillMaxSize()) {
        LazyRow {
            items(itemList) { item ->

                SpaceXFunItem(viewModel, item)
            }
        }
        //ProgressLoadingIndicator(isDisplayed = loading)
    }
}

