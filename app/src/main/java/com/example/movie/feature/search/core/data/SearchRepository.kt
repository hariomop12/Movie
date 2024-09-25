package com.example.movie.feature.search.core.data

import com.example.movie.feature.home.core.domain.modal.MovieVideosModel
import com.example.movie.feature.search.core.data.remote.SearchRemoteDataSource
import com.example.utils.network.ApiResponse
import kotlinx.coroutines.flow.Flow

interface ISearchRepository {

    fun searchMovies(query: String): Flow<ApiResponse<List<MovieVideosModel>>>
}

class SearchRepository(private val searchRemoteDataSource: SearchRemoteDataSource) :
    ISearchRepository {

    override fun searchMovies(query: String): Flow<ApiResponse<List<MovieVideosModel>>> {
        return searchRemoteDataSource.searchMovies(query)
    }
}