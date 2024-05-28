package com.emreozcan.composemovie.presentation.movieDetail

import com.emreozcan.composemovie.domain.model.MovieDetailUiModel

/**
 * Created by @Emre Özcan on 28.05.2024
 */
data class MovieDetailState(
    val isLoading : Boolean = false,
    val movie : MovieDetailUiModel? = null,
    val error : String = ""
)