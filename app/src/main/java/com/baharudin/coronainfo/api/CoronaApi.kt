package com.baharudin.coronainfo.api

import com.baharudin.coronainfo.model.CoronaIndonesiaResponse
import com.baharudin.coronainfo.model.CoronaIndonesiaResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface CoronaApi {

    @GET("indonesia")
    suspend fun getIndonesiaCase() : Response<CoronaIndonesiaResponse>
}