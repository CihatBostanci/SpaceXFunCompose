package com.example.spacexfuncompose.model

import com.google.gson.annotations.SerializedName

data class Payloads(
    @SerializedName("composite_fairing")
    val composite_fairing: CompositeFairing,
    @SerializedName("option_1")
    val option_1: String
)
