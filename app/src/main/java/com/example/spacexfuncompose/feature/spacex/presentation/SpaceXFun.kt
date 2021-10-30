package com.example.spacexfuncompose.feature.spacex.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.model.FavoriteIdEntity
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@Composable
fun SpaceXFun(viewModel: SpaceXViewModel) {

    val itemList: List<AllRocketResponse> by viewModel.rocketList.observeAsState(listOf())
    val favoriteList: List<FavoriteIdEntity> by viewModel.favoriteRocketListLiveData.observeAsState(listOf())
    Row(modifier = Modifier.fillMaxSize()) {
        LazyRow {
            items(itemList) { item ->
                SpaceXFunItem(viewModel, item,
                    favoriteList.any { it.favoriteRocketId == item.id }
                )
            }
        }
    }
}

