package com.baharudin.coronainfo.api

class CoronaRepository {

    suspend fun getIndonesiaCase() =
        RetrofitInstance.api.getIndonesiaCase()
}