package com.example.newsapp.repositoriesContract

import com.example.newsapp.ui.articles.ArticleItem


interface ArticalsReosatory {
    suspend fun getArticalsBySourceId(sourceId:String):List<ArticleItem?>?
}
interface ArticalsRemoteDataSource{
    suspend fun getArticalsBySourceId(sourceId:String):List<ArticleItem?>?
}