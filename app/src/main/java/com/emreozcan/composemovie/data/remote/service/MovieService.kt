package com.emreozcan.composemovie.data.remote.service

import com.emreozcan.composemovie.data.remote.dto.movieDetail.MovieDetailDto
import com.emreozcan.composemovie.data.remote.dto.movieList.MovieListDto
import com.emreozcan.composemovie.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by @Emre Özcan on 27.05.2024
 */
interface MovieService {

    @GET(".")
    suspend fun getMovieList(
        @Query("s") searchString: String, @Query("apikey") apiKey: String = API_KEY
    ): MovieListDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String, @Query("apikey") apiKey: String = API_KEY
    ): MovieDetailDto

}