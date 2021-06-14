package com.example.spacexfuncompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class AllRocketResponse(
    @SerializedName("active")
    val active: Boolean = false,
    @SerializedName("boosters")
    val boosters: Int = -1,
    @SerializedName("company")
    val company: String = "",
    @SerializedName("cost_per_launch")
    val cost_per_launch: Int = 0,
    @SerializedName("country")
    val country: String = "",
    @SerializedName("description")
    val description: String =  "",
    @SerializedName("")
    val diameter: Diameter? = null,
    @SerializedName("engines")
    val engines: Engines? = null,
    @SerializedName("first_flight")
    val first_flight: String = "",
    @SerializedName("first_stage")
    val first_stage: FirstStage? = null,
    @SerializedName("height")
    val height: Height? = null,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("landing_legs")
    val landing_legs: LandingLegs? = null,
    @SerializedName("mass")
    val mass: Mass? = null,
    @SerializedName("payload_weights")
    val payload_weights: List<PayloadWeight>? = null,
    @SerializedName("flickr_images")
    val flickr_images: MutableList<String>? = null,
    @SerializedName("rocket_id")
    val rocket_id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("rocket_type")
    val rocket_type: String = "",
    @SerializedName("second_stage")
    val second_stage: SecondStage? = null,
    @SerializedName("stages")
    val stages: Int = 0,
    @SerializedName("success_rate_pct")
    val success_rate_pct: Int = 0,
    @SerializedName("wikipedia")
    val wikipedia: String = ""
) : Serializable, Parcelable{

    override fun toString(): String {
        return "AllRocketResponse(active=$active, boosters=$boosters, company='$company', cost_per_launch=$cost_per_launch, country='$country', description='$description', diameter=$diameter, engines=$engines, first_flight='$first_flight', first_stage=$first_stage, height=$height, id='$id', landing_legs=$landing_legs, mass=$mass, payload_weights=$payload_weights, flickr_images=$flickr_images, rocket_id='$rocket_id', name='$name', rocket_type='$rocket_type', second_stage=$second_stage, stages=$stages, success_rate_pct=$success_rate_pct, wikipedia='$wikipedia')"
    }
}