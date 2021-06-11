package com.example.spacexfuncompose.feature.spacex

import com.example.spacexfuncompose.model.AllRocketListResponse
import com.example.spacexfuncompose.utils.GET_ALL_ROCKETS
import okhttp3.ResponseBody
import retrofit2.http.GET


interface SpaceXService {
    @GET(GET_ALL_ROCKETS)
    suspend fun getAllRockets(): AllRocketListResponse
}
