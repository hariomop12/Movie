package com.example.movie.feature.home.core.di

import com.example.movie.feature.home.core.data.remote.HomeApiConfig
import com.example.movie.feature.home.core.data.remote.HomeRemoteDataSource
import com.example.movie.feature.home.core.domain.usecase.HomeUseCase


class HomeInjection {

    private fun provideHomeRepository(): com.example.movie.feature.home.core.data.IHomeRepository {
        val remoteDataSource = HomeRemoteDataSource(HomeApiConfig.provideApiService())
        return com.example.movie.feature.home.core.data.HomeRepository(remoteDataSource)
    }

    fun provideHomeUseCase(): HomeUseCase {
        val repository = provideHomeRepository()
        return HomeUseCase(repository)
    }
}