package com.example.news.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Source(
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String
)