package com.example.spacexfuncompose.feature.spacexdetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spacexfuncompose.customcomponent.*
import com.example.spacexfuncompose.model.AllRocketResponse
import com.example.spacexfuncompose.ui.theme.Dimens
import com.example.spacexfuncompose.ui.theme.ScreenSizeManager
import com.example.spacexfuncompose.ui.theme.darkGray
import com.example.spacexfuncompose.ui.theme.lightGray
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Composable
fun SpaceXDetail(viewModel: SpaceXDetailViewModel, rocket: AllRocketResponse?) {

    val (isChecked, setChecked) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(Dimens.dimen_1),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier
                .height((2.5 * ScreenSizeManager.screenHeightDp / 5).dp)
                .align(Alignment.CenterHorizontally)
        ) {
            LazyRow {
                rocket?.flickr_images?.let {
                    items(it.toList()) { item ->
                        RoundedImageComponent(
                            item,
                            modifier = Modifier
                                .width((4 * ScreenSizeManager.screenWidthDp / 5).dp)
                                .height((2.5 * ScreenSizeManager.screenHeightDp / 5).dp)
                                .padding(Dimens.dimen_1)
                        )
                    }
                }
            }
        }

        Card(
            backgroundColor = if (isChecked) darkGray else lightGray,
            shape = RoundedCornerShape(Dimens.dimen_2),
            modifier = Modifier
                .height((1.5 * ScreenSizeManager.screenHeightDp / 5).dp)
                .align(Alignment.CenterHorizontally)
                .padding(Dimens.dimen_1)
        ) {
            Column {
                SpacerSmall()
                HeaderText(
                    text = rocket?.name,
                    modifier = Modifier.align(CenterHorizontally)
                )
                SpacerMedium()
                SimpleText(text = rocket?.description, modifier = Modifier.padding(Dimens.dimen_1))
                SpacerBig()
                FavoriteButton(
                    modifier = Modifier.align(Alignment.End),
                    isChecked = isChecked,
                    onClick = {
                        setChecked(!isChecked)
                        rocket?.let {
                            when (isChecked) {
                                false -> viewModel.addRocketToFavorite(it.id)
                                true -> viewModel.deleteRocketToFavorite(it.id)
                            }
                        }
                    })
            }
        }
    }

}