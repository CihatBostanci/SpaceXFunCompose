package com.example.spacexfuncompose.spacex

import com.example.spacexfuncompose.model.AllRocketsResponseItem
import com.example.spacexfuncompose.utils.GET_ALL_ROCKETS
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.http.GET


interface SpaceXService {
    @GET(GET_ALL_ROCKETS)
    suspend fun getAllRockets(): Flow<MutableList<AllRocketsResponseItem>>
}
