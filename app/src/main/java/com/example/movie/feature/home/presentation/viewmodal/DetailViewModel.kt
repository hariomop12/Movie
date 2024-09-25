package com.example.movie.feature.home.presentation.viewmodal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.movie.feature.home.core.di.HomeInjection
import com.example.movie.feature.home.core.domain.modal.MovieVideosModel
import com.example.utils.network.ApiResponse

class DetailViewModel(private val movieId: String) {
    private var useCase = HomeInjection().provideHomeUseCase()

    var movie = MutableLiveData<MovieVideosModel>()

    init {
        getDetailMovies()
    }

    private fun getDetailMovies() {
        useCase.getMovieDetail(movieId).asLiveData().observeForever { response ->
            when (response) {
                is ApiResponse.Success -> {
                    movie.value = response.data
                    println("Success get detail ${response.data}")
                }

                is ApiResponse.Empty -> {}
                is ApiResponse.Error -> {}
            }
        }
    }

}
