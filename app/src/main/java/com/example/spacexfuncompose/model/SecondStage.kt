package com.example.spacexfuncompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SecondStage(
    @SerializedName("burn_time_sec")
    val burn_time_sec: Int,
    @SerializedName("engines")
    val engines: Int,
    @SerializedName("fuel_amount_tons")
    val fuel_amount_tons: Double,
    @SerializedName("payloads")
    val payloads: Payloads,
    @SerializedName("thrust")
    val thrust: Thrust
): Parcelable