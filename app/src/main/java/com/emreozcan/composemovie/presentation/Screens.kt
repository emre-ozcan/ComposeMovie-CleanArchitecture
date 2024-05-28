package com.emreozcan.composemovie.presentation

import com.emreozcan.composemovie.utils.Constants.MOVIE_DETAIL_SCREEN_ROUTE
import com.emreozcan.composemovie.utils.Constants.MOVIE_LIST_SCREEN_ROUTE

/**
 * Created by @Emre Özcan on 27.05.2024
 */
sealed class Screens(val route: String) {
    data object MovieListScreen: Screens(MOVIE_LIST_SCREEN_ROUTE)
    data object MovieDetailScreen: Screens(MOVIE_DETAIL_SCREEN_ROUTE)
}