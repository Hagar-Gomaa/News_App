package com.example.newsapp.api

import com.example.newsapp.ui.articles.ArticlesResponse
import com.example.newsapp.ui.sources.SourcesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
   @GET("v2/top-headlines/sources")
   suspend fun getSources(@Query("apiKey")apiKey:String,@Query("category",)category:String):SourcesResponse

   @GET("v2/everything")
  suspend fun getArticals(@Query("apiKey")apiKey:String,@Query("sources",)sources:String):ArticlesResponse
}