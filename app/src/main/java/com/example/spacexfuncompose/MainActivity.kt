package com.example.spacexfuncompose

import android.graphics.Point
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.spacexfuncompose.component.SpaceXFunItem
import com.example.spacexfuncompose.data.SpaceXViewItem
import com.example.spacexfuncompose.ui.theme.ScreenSizeManager
import com.example.spacexfuncompose.ui.theme.SpaceXFunComposeTheme
import android.util.DisplayMetrics
import com.example.spacexfuncompose.ui.theme.ScreenSizeManager.displayMetrics
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        screenSizeArranger()
        setContent {
            SpaceXFunComposeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text = "SpaceX Fun") })
                    },
                    content = {
                        // A surface container using the 'background' color from the theme
                        Surface(color = MaterialTheme.colors.background) {
                            SpaceXFun()
                        }
                    }
                )
            }
        }
    }

    private fun screenSizeArranger() {
        ScreenSizeManager.display = windowManager.defaultDisplay
        val size = Point()
        ScreenSizeManager.display?.getSize(size)
        ScreenSizeManager.screenWidth = size.x
        ScreenSizeManager.screenHeight = size.y
        displayMetrics = this.resources.displayMetrics
        displayMetrics?.let {
            ScreenSizeManager.screenHeightDp = it.heightPixels / it.density
            ScreenSizeManager.screenWidthDp = it.widthPixels / it.density
        }


    }
}

@Composable
fun SpaceXFun() {
    val list = listOf(
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
        itemsIndexed(list) { index, item ->
            SpaceXFunItem(spaceXViewItem = item)
        }
    }

}

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
}