package com.baharudin.coronainfo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IndonesiaKasusResponseItem(
    val meninggal: String,
    val name: String,
    val positif: String,
    val sembuh: String
) : Parcelable