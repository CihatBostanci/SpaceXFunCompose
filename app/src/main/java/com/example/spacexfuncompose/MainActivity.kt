package com.example.spacexfuncompose

import android.annotation.SuppressLint
import android.graphics.Point
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spacexfuncompose.feature.spacex.presentation.SpaceXFun
import com.example.spacexfuncompose.feature.spacexdetail.SpaceXDetail
import com.example.spacexfuncompose.navigation.NavigationDirections
import com.example.spacexfuncompose.navigation.NavigationManager
import com.example.spacexfuncompose.ui.theme.ScreenSizeManager
import com.example.spacexfuncompose.ui.theme.ScreenSizeManager.displayMetrics
import com.example.spacexfuncompose.ui.theme.SpaceXFunComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@InternalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager


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
                            mainScreen()
                        }
                    }
                )
            }
        }
    }

    @SuppressLint("ComposableNaming")
    @Composable
    private fun mainScreen() {
        val navController = rememberNavController()
        NavHost(
            navController,
            startDestination = NavigationDirections.SpaceX.destination
        ) {
            composable(NavigationDirections.SpaceX.destination) {
                SpaceXFun(hiltViewModel())
            }
            composable(NavigationDirections.SpaceXDetail.destination) {
                SpaceXDetail(hiltViewModel())
            }
        }
        //observation of destination
        navigationManager.commands.collectAsState().value.also { command ->
            if (command.destination.isNotEmpty()) navController.navigate(command.destination)
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