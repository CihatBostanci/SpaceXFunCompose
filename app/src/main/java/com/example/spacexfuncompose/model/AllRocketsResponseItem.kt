package com.example.spacexfuncompose.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AllRocketsResponseItem(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("boosters")
    val boosters: Int,
    @SerializedName("company")
    val company: String,
    @SerializedName("cost_per_launch")
    val cost_per_launch: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("diameter")
    val diameter: Diameter,
    @SerializedName("engines")
    val engines: Engines,
    @SerializedName("first_flight")
    val first_flight: String,
    @SerializedName("first_stage")
    val first_stage: FirstStage,
    @SerializedName("flickr_images")
    val flickr_images: MutableList<String>,
    @SerializedName("height")
    val height: Height,
    @SerializedName("id")
    val id: String,
    @SerializedName("landing_legs")
    val landing_legs: LandingLegs,
    @SerializedName("mass")
    val mass: Mass,
    @SerializedName("name")
    val name: String,
    @SerializedName("payload_weights")
    val payload_weights: List<PayloadWeight>,
    @SerializedName("second_stage")
    val second_stage: SecondStage,
    @SerializedName("stages")
    val stages: Int,
    @SerializedName("success_rate_pct")
    val success_rate_pct: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("wikipedia")
    val wikipedia: String
) : Serializable {
    override fun toString(): String {
        return "AllRocketsResponseItem(active=$active, boosters=$boosters, company='$company', cost_per_launch=$cost_per_launch, country='$country', description='$description', diameter=$diameter, engines=$engines, first_flight='$first_flight', first_stage=$first_stage, flickr_images=$flickr_images, height=$height, id='$id', landing_legs=$landing_legs, mass=$mass, name='$name', payload_weights=$payload_weights, second_stage=$second_stage, stages=$stages, success_rate_pct=$success_rate_pct, type='$type', wikipedia='$wikipedia')"
    }
}

fun AllRocketsResponseItem.toRocketDetailUIEntity() = RocketDetailUIEntity(
    id = id,
    name = name,
    description = description,
    imageList = flickr_images
)


data class RocketDetailUIEntity(
    val id: String? = "",
    val name: String? = "",
    val description: String? = "",
    val imageList: MutableList<String>
) : Serializable

