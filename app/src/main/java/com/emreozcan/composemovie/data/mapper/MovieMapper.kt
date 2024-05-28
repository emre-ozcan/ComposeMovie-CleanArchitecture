package com.emreozcan.composemovie.data.mapper

import com.emreozcan.composemovie.data.remote.dto.movieDetail.MovieDetailDto
import com.emreozcan.composemovie.data.remote.dto.movieList.MovieListItem
import com.emreozcan.composemovie.domain.model.MovieDetailUiModel
import com.emreozcan.composemovie.domain.model.MovieItemUiModel

/**
 * Created by @Emre Özcan on 27.05.2024
 */
object MovieMapper {

    fun movieListDtoToMovieItemUiModel(movieListItem: MovieListItem?) = MovieItemUiModel(
        poster = movieListItem?.poster ?: "",
        title = movieListItem?.title ?: "",
        year = movieListItem?.year ?: "",
        imdbId = movieListItem?.imdbID ?: "0",
    )

    fun movieDetailDtoToMovieDetailUiModel(movieDetailDto: MovieDetailDto?) = MovieDetailUiModel(
        poster = movieDetailDto?.poster ?: "",
        title = movieDetailDto?.title ?: "",
        year = movieDetailDto?.year ?: "",
        language = movieDetailDto?.language ?: "Unknown",
        plot = movieDetailDto?.plot ?: "Unknown",
        runtime = movieDetailDto?.runtime ?: "Unknown",
    )

}