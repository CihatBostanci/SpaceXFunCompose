package com.example.spacexfuncompose

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.spacexfuncompose.component.SpaceXFunItem
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.spacex.presentation.SpaceXViewModel


@Composable
fun SpaceXFun(viewModel: SpaceXViewModel) {

    val itemList: List<AllRocketResponse> by viewModel.rocketList.observeAsState(listOf())

    LazyRow {
        items(itemList) { item ->
            SpaceXFunItem(item)
        }
    }
    /*val list = listOf(
        SpaceXViewItem(
            imageURL = "https://imgur.com/DaCfMsj.jpg",
            spaceXTitle = "Falcon1",
            spaceXDescription = "Test Description"
        ), SpaceXViewItem(
            imageURL = "https://imgur.com/azYafd8.jpg",
            spaceXTitle = "Falcon1",
            spaceXDescription = "Test Description"
        )
    )
    LazyRow {
        itemsIndexed(list) { _, item ->
            SpaceXFunItem(spaceXViewItem = item)
        }
    }*/

}
/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpaceXFunComposeTheme {
        SpaceXFunItem(
            SpaceXViewItem(
                imageURL = "https://picsum.photos/300/300",
                spaceXTitle = "Falcon1",
                spaceXDescription = "Test Description"
            )
        )
    }
}*/