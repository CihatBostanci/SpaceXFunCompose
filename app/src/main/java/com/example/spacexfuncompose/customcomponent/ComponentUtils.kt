package com.example.spacexfuncompose.customcomponent

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


// Spacer
@Composable
fun SpacerMedium() = Spacer(modifier = Modifier.padding(8.dp))

@Composable
fun SpacerSmall() = Spacer(modifier = Modifier.padding(16.dp))

@Composable
fun SpacerBig() = Spacer(modifier = Modifier.padding(24.dp))
