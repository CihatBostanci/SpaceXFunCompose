package com.example.spacexfuncompose

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.spacexfuncompose.component.SpaceXFunItem
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.feature.spacex.presentation.SpaceXViewModel
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@Composable
fun SpaceXFun( viewModel: SpaceXViewModel) {

    val itemList: List<AllRocketResponse> by viewModel.rocketList.observeAsState(listOf())

    LazyRow {
        items(itemList) { item ->
            SpaceXFunItem(item)
        }
    }
}