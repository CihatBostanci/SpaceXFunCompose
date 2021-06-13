package com.example.spacexfuncompose.navigation

import android.util.Log
import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument
import com.example.spacexfuncompose.navigation.NavigationDirections.Default
import kotlinx.coroutines.flow.MutableStateFlow


interface NavigationCommand {

    val arguments: List<NamedNavArgument>

    val destination: String
}

object NavigationDirections {

    val SpaceX  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "spaceX"
    }

    val SpaceXDetail = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "spaceXDetail"
    }

    val Default = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""
    }

    val Favorite  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "favorite"
    }

    val UpComing  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "favorite"
    }
}

class NavigationManager {

    var commands = MutableStateFlow(Default)

    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }

}