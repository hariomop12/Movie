package com.example.movie.feature.search.core.di

import com.example.movie.feature.search.core.data.ISearchRepository
import com.example.movie.feature.search.core.data.SearchRepository
import com.example.movie.feature.search.core.data.remote.SearchApiConfig
import com.example.movie.feature.search.core.data.remote.SearchRemoteDataSource
import com.example.movie.feature.search.core.domain.SearchUseCase

class SearchInjection {

    private fun provideSearchRepository(): ISearchRepository {
        val remoteDataSource = SearchRemoteDataSource(SearchApiConfig.provideApiService())
        return SearchRepository(remoteDataSource)
    }

    fun provideSearchUseCase(): SearchUseCase {
        val repository = provideSearchRepository()
        return SearchUseCase(repository)
    }


}