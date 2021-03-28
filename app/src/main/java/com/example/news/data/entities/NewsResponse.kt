package com.example.news.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class NewsResponse(
    @Json(name = "articles")
    val articles: List<Article>?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "totalResults")
    val totalResults: Int?
)