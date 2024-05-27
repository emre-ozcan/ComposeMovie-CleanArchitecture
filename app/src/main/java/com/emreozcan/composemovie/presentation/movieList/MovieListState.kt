package com.emreozcan.composemovie.presentation.movieList

import com.emreozcan.composemovie.domain.model.MovieItemUiModel

/**
 * Created by @Emre Özcan on 27.05.2024
 */
data class MovieListState(
    val isLoading: Boolean = false,
    val movieList: List<MovieItemUiModel> = emptyList(),
    val error: String = "",
    val search: String = "Superman"
)