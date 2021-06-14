package com.example.spacexfuncompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Engines(
    @SerializedName("engine_loss_max")
    val engine_loss_max: Int,
    @SerializedName("layout")
    val layout: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("propellant_1")
    val propellant_1: String,
    @SerializedName("propellant_2")
    val propellant_2: String,
    @SerializedName("thrust_sea_level")
    val thrust_sea_level: ThrustSeaLevel,
    @SerializedName("thrust_to_weight")
    val thrust_to_weight: Double,
    @SerializedName("thrust_vacuum")
    val thrust_vacuum: ThrustVacuum,
    @SerializedName("type")
    val type: String,
    @SerializedName("version")
    val version: String
): Parcelable