package com.example.spacexfuncompose.feature.spacex.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spacexfuncompose.customcomponent.*
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.ui.theme.Dimens
import com.example.spacexfuncompose.ui.theme.ScreenSizeManager
import com.example.spacexfuncompose.ui.theme.lightGray
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Composable
fun SpaceXFunItem(
    spaceXViewModel: SpaceXViewModel,
    spaceXViewItem: AllRocketResponse
) {
    Column(
        modifier = Modifier.padding(Dimens.dimen_1),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RoundedImageComponent(
            spaceXViewItem.flickr_images?.get(0),
            modifier = Modifier
                //.clip(shape = RoundedCornerShape(Dimens.dimen_2))
                .height((2.5 * ScreenSizeManager.screenHeightDp / 5).dp)
                .width((4 * ScreenSizeManager.screenWidthDp / 5).dp)
                .align(CenterHorizontally)
                .clickable(onClick = {
                    Log.d("Cihat", "clicked")
                    spaceXViewModel.goToDetail(spaceXViewItem)
                })
            //.padding(Dimens.dimen_2)
        )

        Card(
            backgroundColor = lightGray,
            shape = RoundedCornerShape(Dimens.dimen_2),
            modifier = Modifier
                //.padding(start = Dimens.dimen_2, end = Dimens.dimen_2, bottom = Dimens.dimen_2)
                .height((1.5 * ScreenSizeManager.screenHeightDp / 5).dp)
                .width((4 * ScreenSizeManager.screenWidthDp / 5).dp)
                .align(CenterHorizontally)
        ) {
            Column {
                SpacerSmall()
                HeaderText(
                    text = spaceXViewItem.name,
                    modifier = Modifier.align(CenterHorizontally)
                )
                SpacerMedium()
                SimpleText(text = spaceXViewItem.description)
                SpacerBig()
            }
        }
    }
}
