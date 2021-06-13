package com.example.spacexfuncompose.customcomponent

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun SimpleText(modifier: Modifier = Modifier, text: String? = null) = Text(
    text = if (text.isNullOrEmpty()) "Simple Text" else text,
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.body2,
    modifier = modifier
)


@Composable
fun HeaderText(modifier: Modifier = Modifier, text: String? = null) = Text(
    text = if (text.isNullOrEmpty()) "Simple Text" else text,
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.h1,
    modifier = modifier
)