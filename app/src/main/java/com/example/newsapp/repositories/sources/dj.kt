package com.example.newsapp.repositories.sources

import com.example.newsapp.repositoriesContract.SourceReosatory
import com.example.newsapp.repositoriesContract.SourcesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class SourcesModule {
    @Binds
    abstract fun getSourceRepository(sourRepo: SourcesRepositoryImp):SourceReosatory
}
@Module
@InstallIn(ViewModelComponent::class)
abstract class SourcesRemoteDataSourceModule{
    @Binds
    abstract fun getSourcesRemoteDataSource(sourcesRemote:SourcesRemoteDataSourceImp):SourcesRemoteDataSource
}