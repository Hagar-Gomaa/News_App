package com.example.newsapp.repositories.articles

import com.example.newsapp.repositoriesContract.ArticalsRemoteDataSource
import com.example.newsapp.repositoriesContract.ArticalsReosatory
import com.example.newsapp.ui.articles.ArticleItem
import javax.inject.Inject

class ArticalsRepositoryImp @Inject constructor(val dataSource: ArticalsRemoteDataSource): ArticalsReosatory {
    override suspend fun getArticalsBySourceId(sourceId: String): List<ArticleItem?>? {
        return dataSource.getArticalsBySourceId(sourceId)
    }

}