package com.emreozcan.composemovie.domain.model

/**
 * Created by @Emre Özcan on 27.05.2024
 */
data class MovieDetailUiModel(
    val poster: String,
    val title: String,
    val year: String,
    val language: String,
    val plot: String,
    val runtime: String
)
