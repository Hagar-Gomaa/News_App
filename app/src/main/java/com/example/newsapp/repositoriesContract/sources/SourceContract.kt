package com.example.newsapp.repositoriesContract

import com.example.newsapp.ui.sources.SourcesItem


interface SourceReosatory {
    suspend fun getSourceByCategoryId(cid:String):List<SourcesItem?>?
}
interface SourcesRemoteDataSource{
    suspend fun getSourceByCategoryId(cid:String):List<SourcesItem?>?
}
