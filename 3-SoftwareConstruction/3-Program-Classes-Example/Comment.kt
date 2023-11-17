package com.example.watercleaningapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comment(
    val commentText: String,
    val date: String,
) : Parcelable