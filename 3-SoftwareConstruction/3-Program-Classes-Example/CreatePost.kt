package com.example.watercleaningapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreatePost(
    val text: string,
    val file: string,
) : Parcelable


