package com.example.spacexfuncompose.model

import com.google.gson.annotations.SerializedName

data class Isp(
    @SerializedName("sea_level")
    val sea_level: Int,
    @SerializedName("vacuum")
    val vacuum: Int
)
