package com.example.spacexfuncompose.customcomponent

import android.util.Log
import android.view.View
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.spacexfuncompose.ui.theme.Dimens

private const val LOADING_TAG = "Loading Indicator"

@Composable
fun ProgressLoadingIndicator(isDisplayed: Boolean?) {
    isDisplayed?.let {
        if (isDisplayed) {
            Log.d(LOADING_TAG, "On start")
            Column(
                // imageview to center of the screen.
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),

                // below line is used for specifying
                // vertical arrangement.
                verticalArrangement = Arrangement.Center,

                // below line is used for specifying
                // horizontal arrangement.
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // below line is use to display
                // a circular progress bar.
                CircularProgressIndicator(
                    // below line is use to add padding
                    // to our progress bar.
                    modifier = Modifier.padding(16.dp),

                    // below line is use to add color
                    // to our progress bar.
                    color = MaterialTheme.colors.primary,

                    // below line is use to add stroke
                    // width to our progress bar.
                    strokeWidth = Dp(value = 4F)
                )
            }

        }
    }
}

