package com.example.spacexfuncompose.model

import com.google.gson.annotations.SerializedName

data class FirstStage(
    @SerializedName("burn_time_sec")
    val burn_time_sec: Int,
    @SerializedName("engines")
    val engines: Int,
    @SerializedName("fuel_amount_tons")
    val fuel_amount_tons: Double,
    @SerializedName("reusable")
    val reusable: Boolean,
    @SerializedName("thrust_sea_level")
    val thrust_sea_level: ThrustSeaLevelX,
    @SerializedName("thrust_vacuum")
    val thrust_vacuum: ThrustVacuumX
)