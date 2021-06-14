package com.example.spacexfuncompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Payloads(
    @SerializedName("composite_fairing")
    val composite_fairing: CompositeFairing,
    @SerializedName("option_1")
    val option_1: String,
    @SerializedName("option_2")
    val option_2: String
): Parcelable