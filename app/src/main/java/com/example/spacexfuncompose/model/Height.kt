package com.example.spacexfuncompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Height(
    @SerializedName("feet")
    val feet: Double,
    @SerializedName("meters")
    val meters: Double
): Parcelable