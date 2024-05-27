package com.emreozcan.composemovie.presentation.movieList.views

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.emreozcan.composemovie.presentation.movieList.MovieListViewModel

/**
 * Created by @Emre Özcan on 27.05.2024
 */
@Composable
fun MovieListScreen(navController: NavController, viewModel: MovieListViewModel = hiltViewModel()) {
    val state = viewModel.state.value


}