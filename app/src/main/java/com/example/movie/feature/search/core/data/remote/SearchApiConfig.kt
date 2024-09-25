package com.example.movie.feature.search.core.data.remote

import com.example.utils.RetrofitHelper

object SearchApiConfig {

        private const val BASE_URL = "https://api.themoviedb.org/"

        fun provideApiService(): SearchService {
            return RetrofitHelper.createService(BASE_URL).create(SearchService::class.java)
        }
}
