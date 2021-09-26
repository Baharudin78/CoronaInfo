package com.baharudin.coronainfo.api

class CoronaRepository {

    suspend fun getIndonesiaCase() =
        RetrofitInstance.api.getIndonesiaCase()
    suspend fun getPositifCase() =
            RetrofitInstance.api.getPositifCase()
    suspend fun getSembuhCase() =
            RetrofitInstance.api.getSembuhCase()
    suspend fun getMeninggalCase() =
            RetrofitInstance.api.getMeninggalCase()
}