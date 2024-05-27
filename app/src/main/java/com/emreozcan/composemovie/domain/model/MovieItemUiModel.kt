package com.emreozcan.composemovie.domain.model

/**
 * Created by @Emre Özcan on 27.05.2024
 */
data class MovieItemUiModel(
    private val poster: String,
    private val title: String,
    private val year: String,
    private val imdbId: String
)