package com.example.spacexfuncompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.spacexfuncompose.R

val openSans =  Font(R.font.opensansregular)

val openSansFamily = FontFamily(openSans)

val MyTypography = Typography(
    h1 = TextStyle(
        fontFamily = openSansFamily,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 18.sp
    ),
    body1 = TextStyle(
        fontFamily = openSansFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = openSansFamily,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    )



)
