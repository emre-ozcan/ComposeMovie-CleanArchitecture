package com.emreozcan.composemovie.domain.repository

import com.emreozcan.composemovie.data.remote.dto.movieList.MovieListDto

/**
 * Created by @Emre Özcan on 27.05.2024
 */
interface MovieListRepository {
    suspend fun getMovieList(search: String): MovieListDto
}