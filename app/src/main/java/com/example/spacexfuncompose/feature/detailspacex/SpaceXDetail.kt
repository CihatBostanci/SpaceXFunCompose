package com.example.spacexfuncompose.feature.detailspacex

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
fun SpaceXDetail(
    viewModel: SpaceXDetailViewModel,
    rocket: AllRocketResponse?
) {

    Log.d("Cİhat Logged", viewModel.isFavoriteLiveData.value.toString())

    val isFavoriteState: State<Boolean> = viewModel.isFavoriteLiveData.observeAsState(false)

    Column(
        modifier = Modifier.padding(Dimens.dimen_1),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var (isChecked, setChecked) = remember { mutableStateOf(isFavoriteState) }

        Row(
            modifier = Modifier
                .height((2.5 * ScreenSizeManager.screenHeightDp / 5).dp)
                .align(CenterHorizontally)
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
            backgroundColor = if (isChecked.value) darkGray else lightGray,
            shape = RoundedCornerShape(Dimens.dimen_2),
            modifier = Modifier
                .height((1.5 * ScreenSizeManager.screenHeightDp / 5).dp)
                .align(CenterHorizontally)
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
                    isChecked = isChecked?.value ?: run { false },
                    onClick = {
                        setChecked(isChecked.apply { !value })
                        rocket?.let {
                            when (isChecked.value) {
                                false -> viewModel.addRocketToFavorite(it.id)
                                true -> viewModel.deleteRocketToFavorite(it.id)
                            }
                        }
                    }
                )
            }
        }
    }
}
