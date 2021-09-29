package com.baharudin.coronainfo.model.country

import com.google.gson.annotations.SerializedName

data class CountryResponseItem(
    val Active: Int,
    @SerializedName("Confirmed")
    val confirmed: Int,
    @SerializedName("Country_Region")
    val country: String,
    @SerializedName("Deaths")
    val deaths: Int,
    val Last_Update: Long,
    val Lat: Double,
    val Long_: Double,
    val OBJECTID: Int,
    @SerializedName("Recovered")
    val recovered: Int
)