package com.example.spacexfuncompose.customcomponent

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.spacexfuncompose.ui.theme.openSansFamily

@Composable
fun SimpleText(modifier: Modifier = Modifier, text: String? = null) = Text(
    text = if (text.isNullOrEmpty()) "Simple Text View" else text,
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.body1,
    modifier = modifier
)


@Composable
fun HeaderText(modifier: Modifier = Modifier, text: String? = null) = Text(
    text = if (text.isNullOrEmpty()) "Simple Text View" else text,
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.h1,
    modifier = modifier
)