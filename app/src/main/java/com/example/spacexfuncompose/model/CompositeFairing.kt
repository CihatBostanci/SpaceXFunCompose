package com.example.spacexfuncompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompositeFairing(
    @SerializedName("diameter")
    val diameter: DiameterX,
    @SerializedName("height")
    val height: HeightX
): Parcelable