package com.example.news.di

import com.example.news.data.remote.NewsApi
import com.example.news.utils.Constant
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


//بعد از ساخت NewsApp
//باید بگیم در سطح کل اپلیکیشن ساخته بشه روتروفیت، این شی را نگه دار تا زمانی که اجرا میشه
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideMoshi() : Moshi = Moshi.Builder().build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi):Retrofit=Retrofit.Builder().addConverterFactory(MoshiConverterFactory
        .create(moshi)).baseUrl(Constant.BASE_URL).build()

    @Singleton
    @Provides
    fun provideNewsApi(retrofit: Retrofit) = retrofit.create(NewsApi::class.java)

}