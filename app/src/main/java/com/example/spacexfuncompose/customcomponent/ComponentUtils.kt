package com.example.spacexfuncompose.customcomponent

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.spacexfuncompose.ui.theme.Dimens


// Spacer
@Composable
fun SpacerMedium() = Spacer(modifier = Modifier.padding(Dimens.dimen_1))

@Composable
fun SpacerSmall() = Spacer(modifier = Modifier.padding(Dimens.dimen_1_5))

@Composable
fun SpacerBig() = Spacer(modifier = Modifier.padding(Dimens.dimen_2))
