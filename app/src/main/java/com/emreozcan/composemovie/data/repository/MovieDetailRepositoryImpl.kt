package com.emreozcan.composemovie.data.repository

import com.emreozcan.composemovie.data.remote.dto.movieDetail.MovieDetailDto
import com.emreozcan.composemovie.data.remote.service.MovieService
import com.emreozcan.composemovie.domain.repository.MovieDetailRepository
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 27.05.2024
 */
class MovieDetailRepositoryImpl @Inject constructor(private val service: MovieService) :
    MovieDetailRepository {
    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return service.getMovieDetail(imdbId = imdbId)
    }
}