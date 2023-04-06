package com.example.newsapp.ui.articles

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class AdapterModule(){
    @Provides
    fun provideAdapter():ArticleAdapter{
        return ArticleAdapter(null)
    }
}