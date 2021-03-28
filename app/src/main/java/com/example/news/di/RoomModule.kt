package com.example.news.di

import android.content.Context
import androidx.room.Room
import com.example.news.data.cash.NewsDataBase
import com.example.news.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideNewsDatabase(@ApplicationContext appContext:Context)=Room.databaseBuilder(appContext,NewsDataBase
    ::class.java,Constant.DB_NAME).fallbackToDestructiveMigration().build()
    @Singleton
    @Provides
    fun provideNewsDao (db:NewsDataBase)=db.newsDao
}