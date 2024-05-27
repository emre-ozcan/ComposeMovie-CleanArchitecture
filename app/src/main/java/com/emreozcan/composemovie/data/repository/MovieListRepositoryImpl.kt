package com.emreozcan.composemovie.data.repository

import com.emreozcan.composemovie.data.remote.dto.movieList.MovieListDto
import com.emreozcan.composemovie.data.remote.service.MovieService
import com.emreozcan.composemovie.domain.repository.MovieListRepository
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 27.05.2024
 */
class MovieListRepositoryImpl @Inject constructor(private val service: MovieService) :
    MovieListRepository {
    override suspend fun getMovieList(search: String): MovieListDto {
        return service.getMovieList(searchString = search)
    }

}