package com.example.summerpractice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatModel(
    val id: Int,
    val title: String,
    val description: String,
    var imageResId: Int
) : Parcelable