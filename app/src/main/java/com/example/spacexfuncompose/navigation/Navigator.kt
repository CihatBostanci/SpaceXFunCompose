package com.example.spacexfuncompose.navigation

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.NamedNavArgument
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.navigation.NavigationDirections.Default
import kotlinx.coroutines.flow.MutableStateFlow

const val SPACE_X_DETAIL_DESTINATION = "spaceXDetail/{rocket}"
const val SPACE_X_DESTINATION = "spaceX"
const val DEFAULT_DESTINATION = ""
const val FAVORITE_DESTINATION = "favorite"
const val UP_COMING_DESTINATION = "upComing"

interface NavigationCommand {

    var arguments: Bundle

    val destination: String
}

object NavigationDirections {

    val Default = object : NavigationCommand {

        override var arguments = Bundle()

        override val destination = DEFAULT_DESTINATION
    }

    val SpaceX = object : NavigationCommand {

        override var arguments = Bundle()

        override val destination = SPACE_X_DESTINATION
    }

    val SpaceXDetail = object : NavigationCommand {

        override var arguments = Bundle()

        override val destination = SPACE_X_DETAIL_DESTINATION
    }

    val Favorite = object : NavigationCommand {

        override var arguments = Bundle()

        override val destination = FAVORITE_DESTINATION
    }

    val UpComing = object : NavigationCommand {

        override var arguments = Bundle()

        override val destination = UP_COMING_DESTINATION
    }
}

class NavigationManager {

    var commands = MutableStateFlow(Default)

    private var _bundle: Bundle = Bundle()
    val bundle: Bundle get() = _bundle

    fun navigate(
        directions: NavigationCommand
    ) {
        _bundle = directions.arguments
        commands.value = directions
    }

}