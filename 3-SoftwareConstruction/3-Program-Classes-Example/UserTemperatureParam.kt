package com.example.watercleaningapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserTemperatureParam(
    val air_purifier: Boolean,
    val temperature: Int,
    val mode: String,
    val automatic_settings: Boolean,
) : Parcelable