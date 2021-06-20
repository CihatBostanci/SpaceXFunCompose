package com.example.spacexfuncompose.customcomponent

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.spacexfuncompose.R

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onClick: () -> Unit
) {
    IconToggleButton(
        modifier = modifier,
        checked = isChecked,
        onCheckedChange = { onClick() }
    ) {

        val transition = updateTransition(isChecked, label = "Checked indicator")
        val size by transition.animateDp(
            transitionSpec = {
                if (false isTransitioningTo true) {
                    keyframes {
                        durationMillis = 500
                        30.dp at 0 with LinearOutSlowInEasing // for 0-15 ms
                        35.dp at 15 with FastOutLinearInEasing // for 15-75 ms
                        40.dp at 75 // ms
                        35.dp at 150 // ms
                    }
                } else {
                    spring(stiffness = Spring.StiffnessVeryLow)
                }
            },
            label = "Size"
        ) { 30.dp }

        Image(
            painter = if (isChecked) painterResource(id = R.drawable.ic_baseline_favorite_24)
            else painterResource(id = R.drawable.ic_baseline_favorite_border_24),
            contentDescription = null,
            modifier = Modifier.size(size)
        )
    }
}
