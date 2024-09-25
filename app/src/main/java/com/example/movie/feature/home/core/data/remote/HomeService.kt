package com.example.movie.feature.home.core.data.remote

import com.example.movie.BuildConfig
import com.example.movie.feature.home.core.domain.modal.MovieVideosModel
import com.example.movie.feature.home.core.domain.modal.MovieVideosResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeService {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String = BuildConfig.API_KEY): MovieVideosResponse

    @GET("3/movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String = BuildConfig.API_KEY): MovieVideosResponse

    @GET("3/movie/top_rated")
    suspend fun getNowPlayingMovies(@Query("api_key") apiKey: String = BuildConfig.API_KEY): MovieVideosResponse

    @GET("3/movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") id: String,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): MovieVideosModel
}