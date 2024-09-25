package com.example.movie.feature.search.core.domain

import com.example.movie.feature.home.core.domain.modal.MovieVideosModel
import com.example.movie.feature.search.core.data.ISearchRepository
import com.example.utils.network.ApiResponse
import kotlinx.coroutines.flow.Flow

interface ISearchUseCase {
    fun searchMovies(query: String): Flow<ApiResponse<List<MovieVideosModel>>>
}

class SearchUseCase(private val repository: ISearchRepository) : ISearchUseCase {

    override fun searchMovies(query: String): Flow<ApiResponse<List<MovieVideosModel>>> {
        return repository.searchMovies(query)
    }
}