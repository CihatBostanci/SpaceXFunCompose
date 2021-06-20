package com.example.spacexfuncompose.customcomponent

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

private const val LOADING_TAG = "Loading Indicator"

@Composable
fun ProgressLoadingIndicator(isDisplayed: Boolean?) {
    isDisplayed?.let {
        if (isDisplayed) {
            Log.d(LOADING_TAG, "On start")
            Column(
                // imageview to center of the screen.
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),

                // below line is used for specifying
                // vertical arrangement.
                verticalArrangement = Arrangement.Center,

                // below line is used for specifying
                // horizontal arrangement.
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val context = LocalContext.current

                /*val imageLoader = ImageLoader.Builder(context)
                    .componentRegistry {
                        if (SDK_INT >= 28) {
                            add(ImageDecoderDecoder(context))
                        } else {
                            add(GifDecoder())
                        }
                    }.build()*/
            }
        }
    }
}

