package com.example.spacexfuncompose.model

import com.google.gson.annotations.SerializedName

data class LandingLegs(
    @SerializedName("material")
    val material: String,
    @SerializedName("number")
    val number: Int
)
