package com.example.spacexfuncompose

import android.graphics.Point
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.listSaver
import com.example.spacexfuncompose.model.AllRocketListResponse
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.spacex.presentation.SpaceXViewModel
import com.example.spacexfuncompose.ui.theme.ScreenSizeManager
import com.example.spacexfuncompose.ui.theme.ScreenSizeManager.displayMetrics
import com.example.spacexfuncompose.ui.theme.SpaceXFunComposeTheme
import com.example.spacexfuncompose.utils.IntentUtil
import com.example.spacexfuncompose.utils.observeLiveData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SpaceXViewModel by viewModels()

    @InternalCoroutinesApi
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
                            viewModel.run {
                                getSpaceXRockets()
                            }
                                /*observeLiveData(rocketList) {
                                    val dataModel = IntentUtil.gson.fromJson(
                                        it.charStream(), AllRocketListResponse::class.java
                                    )
                                    Log.d("Main", dataModel.toString())

                                }*/
                                SpaceXFun(viewModel )

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