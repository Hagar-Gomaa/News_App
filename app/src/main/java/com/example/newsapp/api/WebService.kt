package com.example.newsapp.api

import com.example.newsapp.model.news.ArticlesResponse
import com.example.newsapp.model.sources.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
   @GET("v2/top-headlines/sources")
   fun getSources(@Query("apiKey")apiKey:String,@Query("category",)category:String):Call<SourcesResponse>

   @GET("v2/everything")
   fun getArticals(@Query("apiKey")apiKey:String,@Query("sources",)sources:String):Call<ArticlesResponse>
}