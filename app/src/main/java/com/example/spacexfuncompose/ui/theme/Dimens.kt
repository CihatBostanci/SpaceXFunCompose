package com.example.spacexfuncompose.ui.theme

import android.util.DisplayMetrics
import android.view.Display
import androidx.compose.ui.unit.dp

/**
 * An 8dp grid system. Smaller components can align to a 2dp 'sub' grid.
 */
object Dimens {
    val dimen_0_25 = 2.dp
    val dimen_0_5 = 4.dp
    val dimen_1 = 8.dp
    val dimen_1_5 = 12.dp
    val dimen_2 = 16.dp
    val dimen_2_5 = 20.dp
    val dimen_3 = 24.dp
    val dimen_3_5 = 28.dp
    val dimen_4 = 32.dp
    val dimen_4_5 = 36.dp
    val dimen_5 = 40.dp
    val dimen_5_5 = 44.dp
    val dimen_6 = 48.dp
}

object ScreenSizeManager {
    var screenHeight = 0
    var screenWidth = 0
    var display: Display? = null
    var displayMetrics: DisplayMetrics? = null

    var screenWidthDp: Float = 0.0f
    var screenHeightDp: Float = 0.0f
}
