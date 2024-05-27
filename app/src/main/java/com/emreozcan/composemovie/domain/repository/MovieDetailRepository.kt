package com.emreozcan.composemovie.domain.repository

import com.emreozcan.composemovie.data.remote.dto.movieDetail.MovieDetailDto

/**
 * Created by @Emre Özcan on 27.05.2024
 */
interface MovieDetailRepository {

    suspend fun getMovieDetail(imdbId: String): MovieDetailDto
}