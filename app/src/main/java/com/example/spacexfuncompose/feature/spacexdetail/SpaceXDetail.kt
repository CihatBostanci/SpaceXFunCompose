package com.example.spacexfuncompose.feature.spacexdetail

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.spacexfuncompose.customcomponent.*
import com.example.spacexfuncompose.feature.spacex.presentation.SpaceXViewModel
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.ui.theme.Dimens
import com.example.spacexfuncompose.ui.theme.lightGray
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Composable
fun SpaceXDetail(viewModel: SpaceXDetailViewModel) {

    viewModel.loadRocket()
    val spaceXViewItem: AllRocketResponse by viewModel.rocket.observeAsState(AllRocketResponse())
        Column(
            modifier = Modifier.padding(Dimens.dimen_1),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            RoundedImageComponent(
                spaceXViewItem.flickr_images?.get(0),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                //.padding(Dimens.dimen_2)
            )

            Card(
                backgroundColor = lightGray,
                shape = RoundedCornerShape(Dimens.dimen_2),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Column {
                    SpacerSmall()
                    HeaderText(
                        text = spaceXViewItem.name,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    SpacerMedium()
                    SimpleText(text = spaceXViewItem.description)
                    SpacerBig()
                }
            }
        }
}