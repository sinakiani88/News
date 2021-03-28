package com.example.news.repository

import com.example.news.data.cash.NewsDao
import com.example.news.data.entities.NewsResponse
import com.example.news.data.remote.NewsApi
import com.example.news.utils.Resource
import com.example.news.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.lang.Exception

import javax.inject.Inject

class BreakingNewsRepository @Inject constructor(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
    ):BreakingRepositoryDataSource {
    override suspend fun getBreakingNews(
        countryCode: String,
        pageNumber: Int
    ): Flow<Resource<NewsResponse, String>> = flow {
        try {
            newsApi.getBreakingNews(countryCode=countryCode,pageNumber=pageNumber).run {
                emit(Resource.success<NewsResponse,String>(this))
            }
        }catch (e:Exception){
            emit(Resource.error<NewsResponse,String>(message = e.message.toString()))
        }

    }.flowOn(Dispatchers.IO)
}