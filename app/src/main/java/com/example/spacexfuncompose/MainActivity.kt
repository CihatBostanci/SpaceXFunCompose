package com.example.spacexfuncompose

import android.graphics.Point
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.spacexfuncompose.model.AllRocketsResponseItem
import com.example.spacexfuncompose.spacex.presentation.SpaceXViewModel
import com.example.spacexfuncompose.ui.theme.ScreenSizeManager
import com.example.spacexfuncompose.ui.theme.ScreenSizeManager.displayMetrics
import com.example.spacexfuncompose.ui.theme.SpaceXFunComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SpaceXViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        screenSizeArranger()
        //callService()
        setContent {
            SpaceXFunComposeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text = "SpaceX Fun") })
                    },
                    content = {
                        // A surface container using the 'background' color from the theme
                        Surface(color = MaterialTheme.colors.background) {
                            viewModel.getSpaceXRockets()
                            val items: List<AllRocketsResponseItem> by viewModel.rocketList.observeAsState(listOf())
                            SpaceXFun(items)
                        }
                    }
                )
            }
        }
    }

    private fun callService() {
        viewModel.run {
           // getSpaceXRockets()
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