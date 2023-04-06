package com.example.newsapp.repositories.articles

import com.example.newsapp.repositoriesContract.ArticalsRemoteDataSource
import com.example.newsapp.repositoriesContract.ArticalsReosatory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun getReposoitry(articleRepo: ArticalsRepositoryImp): ArticalsReosatory
}
@Module
@InstallIn(ViewModelComponent::class)
abstract class ArticlesRemoteDataSourceModule{
    @Binds
    abstract fun getArticleRemoteDataSource(articlesRemotData:ArticlesRemotDataSourceImp):ArticalsRemoteDataSource

}