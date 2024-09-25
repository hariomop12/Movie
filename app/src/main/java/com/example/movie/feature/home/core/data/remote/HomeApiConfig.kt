package com.example.movie.feature.home.core.data.remote

import com.example.utils.RetrofitHelper

object HomeApiConfig {

    private const val BASE_URL = "https://api.themoviedb.org/"

    fun provideApiService(): com.example.movie.feature.home.core.data.remote.HomeService {
        return RetrofitHelper.createService(com.example.movie.feature.home.core.data.remote.HomeApiConfig.BASE_URL)
            .create(
                com.example.movie.feature.home.core.data.remote.HomeService::class.java
            )
    }
}