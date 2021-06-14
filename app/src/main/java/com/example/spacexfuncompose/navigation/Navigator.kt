package com.example.spacexfuncompose.navigation

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.NamedNavArgument
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.navigation.NavigationDirections.Default
import kotlinx.coroutines.flow.MutableStateFlow


interface NavigationCommand {

    var arguments: Bundle

    val destination: String
}

object NavigationDirections {

    val SpaceX = object : NavigationCommand {

        override var arguments = Bundle()

        override val destination = "spaceX"
    }

    val SpaceXDetail = object : NavigationCommand {

        override var arguments = Bundle()

        override val destination = "spaceXDetail"
    }

    val Default = object : NavigationCommand {

        override var arguments = Bundle()

        override val destination = ""
    }

    val Favorite = object : NavigationCommand {

        override var arguments = Bundle()

        override val destination = "favorite"
    }

    val UpComing = object : NavigationCommand {

        override var arguments = Bundle()

        override val destination = "favorite"
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