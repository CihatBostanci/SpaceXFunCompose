package com.example.spacexfuncompose.model

import com.google.gson.annotations.SerializedName

data class ThrustSeaLevel(
    @SerializedName("kN")
    val kN: Int,
    @SerializedName("lbf")
    val lbf: Int
)
