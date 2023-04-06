package com.example.newsapp

import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
@HiltAndroidApp
class MyApplication:android.app.Application() {
    override fun onCreate() {
        super.onCreate()
    }
}