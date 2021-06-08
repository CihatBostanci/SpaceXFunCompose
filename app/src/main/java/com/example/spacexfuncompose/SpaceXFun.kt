package com.example.spacexfuncompose

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.spacexfuncompose.component.SpaceXFunItem
import com.example.spacexfuncompose.model.AllRocketsResponseItem


@Composable
fun SpaceXFun(items: List<AllRocketsResponseItem>) {

    LazyRow {
        itemsIndexed(items = items) { _, item ->
            SpaceXFunItem(spaceXViewItem = item)
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