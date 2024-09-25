package com.example.movie.feature.search.core.data.remote

import com.example.movie.feature.home.core.domain.modal.MovieVideosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("3/search/movie?api_key=09e944d481182594526386cd00f35b26")
    suspend fun searchMovies(
        @Query("query") query: String
    ): MovieVideosResponse
}