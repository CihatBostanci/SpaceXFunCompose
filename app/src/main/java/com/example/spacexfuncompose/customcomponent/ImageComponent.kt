package com.example.spacexfuncompose.customcomponent


import com.example.spacexfuncompose.R
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.spacexfuncompose.ui.theme.Dimens
import com.google.accompanist.coil.rememberCoilPainter


//Image View Component Utils
@Composable
fun SimpleImageComponent(imageURL: String?) {
    // Image is a composable that is used to display some image.
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = if (imageURL.isNullOrEmpty())
                painterResource(R.drawable.ic_launcher_foreground)
            else
                rememberCoilPainter(
                    request = imageURL
                ),
            contentDescription = null
        )
    }
}

@SuppressLint("ModifierParameter")
@Composable
fun RoundedImageComponent(
    imageURL: String? = null,  modifier: Modifier = Modifier
) {
    Card(modifier= modifier, RoundedCornerShape(Dimens.dimen_2)){
        Image(
            painter = if (imageURL.isNullOrEmpty())
                painterResource(R.drawable.ic_launcher_foreground)
            else
                rememberCoilPainter(
                    request = imageURL
                ),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
    }
}