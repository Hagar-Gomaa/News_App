package com.example.newsapp.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiManagerModule {

    @Provides
     fun getGson(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun getRetrofit(gson: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(gson)
            .build()

    }

    @Provides
    fun getWebService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }
}