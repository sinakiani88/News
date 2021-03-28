package com.example.news.di

import com.example.news.data.cash.NewsDao
import com.example.news.data.remote.NewsApi
import com.example.news.repository.BreakingNewsRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    fun provideBreakingNewsRepository(newsApi: NewsApi,newsDao: NewsDao)=BreakingNewsRepository(newsApi,newsDao)
}