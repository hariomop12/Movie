package com.example.movie.feature.search.core.data.remote

import com.example.movie.feature.home.core.domain.modal.MovieVideosModel
import com.example.utils.network.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SearchRemoteDataSource(private val service: SearchService) {

    fun searchMovies(query: String): Flow<ApiResponse<List<MovieVideosModel>>> {
        return flow {
            try {
                val response = service.searchMovies(query)
                val dataArray = response.results

                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}