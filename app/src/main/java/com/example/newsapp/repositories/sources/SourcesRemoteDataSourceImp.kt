package com.example.newsapp.repositories.sources

import com.example.newsapp.Constans
import com.example.newsapp.api.WebService
import com.example.newsapp.repositoriesContract.SourcesRemoteDataSource
import com.example.newsapp.ui.sources.SourcesItem
import javax.inject.Inject

class SourcesRemoteDataSourceImp @Inject constructor(val webService: WebService): SourcesRemoteDataSource {
    override suspend fun getSourceByCategoryId(cid: String): List<SourcesItem?>? {
        return webService.getSources(Constans.apiKey,cid).sources
    }
}