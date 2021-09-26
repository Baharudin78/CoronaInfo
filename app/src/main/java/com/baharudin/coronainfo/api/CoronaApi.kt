package com.baharudin.coronainfo.api

import com.baharudin.coronainfo.model.indonesia.CoronaIndonesiaResponse
import com.baharudin.coronainfo.model.world.WorldDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoronaApi {
    @GET("indonesia")
    suspend fun getIndonesiaCase() : Response<CoronaIndonesiaResponse>
    @GET("positif")
    suspend fun getPositifCase() : Response<WorldDataResponse>
    @GET("sembuh")
    suspend fun getSembuhCase() : Response<WorldDataResponse>
    @GET("meninggal")
    suspend fun getMeninggalCase() : Response<WorldDataResponse>
}