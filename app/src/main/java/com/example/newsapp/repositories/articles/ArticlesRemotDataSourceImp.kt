package com.example.newsapp.repositories.articles

import com.example.newsapp.Constans
import com.example.newsapp.api.WebService
import com.example.newsapp.repositoriesContract.ArticalsRemoteDataSource
import com.example.newsapp.ui.articles.ArticleItem
import javax.inject.Inject

class ArticlesRemotDataSourceImp @Inject constructor(val webService: WebService) :ArticalsRemoteDataSource{
    override suspend fun getArticalsBySourceId(sourceId: String): List<ArticleItem?>? {
        return webService.getArticals(Constans.apiKey,sourceId).articles
    }
}