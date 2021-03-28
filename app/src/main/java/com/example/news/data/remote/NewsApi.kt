package com.example.news.data.remote

import com.example.news.BuildConfig
import com.example.news.data.entities.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("country") countryCode:String="us",
        @Query("page") pageNumber:Int=1,
        @Query("apiKey") apiKey:String= BuildConfig.API_KEY
    ):NewsResponse
    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery:String,
        @Query("page") pageNumber:Int=1,
        @Query("apiKey") apiKey:String=BuildConfig.API_KEY
    ):NewsResponse
}