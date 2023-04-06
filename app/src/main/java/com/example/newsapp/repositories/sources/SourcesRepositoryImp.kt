package com.example.newsapp.repositories.sources

import com.example.newsapp.repositoriesContract.SourceReosatory
import com.example.newsapp.repositoriesContract.SourcesRemoteDataSource
import com.example.newsapp.ui.sources.SourcesItem
import javax.inject.Inject

class SourcesRepositoryImp @Inject constructor(val dataSource: SourcesRemoteDataSource):SourceReosatory {
    override suspend fun getSourceByCategoryId(cid: String): List<SourcesItem?>? {
     return dataSource.getSourceByCategoryId(cid)   }
}