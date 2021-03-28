package com.example.news.repository

import com.example.news.data.entities.NewsResponse
import com.example.news.utils.Resource
import kotlinx.coroutines.flow.Flow


interface BreakingRepositoryDataSource {
    suspend fun getBreakingNews(countryCode:String,pageNumber:Int):Flow<Resource<NewsResponse,String>>
}