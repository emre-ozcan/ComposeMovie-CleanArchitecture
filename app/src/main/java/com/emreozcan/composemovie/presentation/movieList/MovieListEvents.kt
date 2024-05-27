package com.emreozcan.composemovie.presentation.movieList

/**
 * Created by @Emre Özcan on 27.05.2024
 */
sealed class MovieListEvents {
    data class Search(val searchString: String): MovieListEvents()
}