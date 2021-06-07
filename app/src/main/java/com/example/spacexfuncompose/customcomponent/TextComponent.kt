package com.example.spacexfuncompose.customcomponent

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun SimpleText(modifier: Modifier = Modifier, text: String? = null) = Text(
    text = if (text.isNullOrEmpty()) "Simple Text View" else text,
    textAlign = TextAlign.Center,
    style = TextStyle(
        fontSize = 16.sp
    ),
    modifier = modifier
)
