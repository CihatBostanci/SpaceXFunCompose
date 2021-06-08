package com.example.spacexfuncompose.model

import com.google.gson.annotations.SerializedName

data class AllRocketsResponse (
    @SerializedName("rockets")
    val rockets: MutableList<AllRocketsResponseItem>
) {

}