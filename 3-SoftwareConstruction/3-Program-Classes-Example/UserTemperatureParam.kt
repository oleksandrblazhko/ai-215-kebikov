package com.example.watercleaningapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserTemperatureParam(
    val temperature: Int,
    val mode: String,
) : Parcelable
