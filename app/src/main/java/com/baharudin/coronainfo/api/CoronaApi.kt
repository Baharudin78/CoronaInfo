package com.baharudin.coronainfo.api

import com.baharudin.coronainfo.model.IndonesiaKasusResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoronaApi {
    companion object {
        const val BASE_URL = "https://api.kawalcorona.com/"
    }
    @GET("indonesia")
    suspend fun getIndonesiaCase() : Response<IndonesiaKasusResponse>
}