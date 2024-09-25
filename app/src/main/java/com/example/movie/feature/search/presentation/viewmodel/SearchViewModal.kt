package com.example.movie.feature.search.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.movie.feature.home.core.domain.modal.MovieVideosModel
import com.example.movie.feature.search.core.di.SearchInjection
import com.example.utils.network.ApiResponse

class SearchViewModal {
    private var useCase = SearchInjection().provideSearchUseCase()

    var movies = MutableLiveData<List<MovieVideosModel>>()

    fun searchVideos(query: String) {
        useCase.searchMovies(query).asLiveData().observeForever { response ->
            when (response) {
                is ApiResponse.Success -> {
                    movies.value = response.data
                }

                is ApiResponse.Error -> {
                    movies.value = emptyList()
                }

                is ApiResponse.Empty -> {
                    movies.value = emptyList()
                }
            }
        }
    }
}
