package com.example.watercleaningapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInformation(
    val photo: String,
    val email: String,
    val nickname: String,
) : Parcelable