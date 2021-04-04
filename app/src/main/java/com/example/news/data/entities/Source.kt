package com.example.news.data.entities


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class Source(
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String
):Parcelable