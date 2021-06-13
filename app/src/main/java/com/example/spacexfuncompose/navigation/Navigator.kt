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

    val spaceX  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "spaceX"
    }

    val spaceXDetail = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "spaceXDetail"
    }

    val Default = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""
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