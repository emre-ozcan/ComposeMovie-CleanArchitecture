package com.emreozcan.composemovie.presentation.movieList.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.emreozcan.composemovie.presentation.common.ErrorText
import com.emreozcan.composemovie.presentation.movieList.MovieListViewModel

/**
 * Created by @Emre Özcan on 27.05.2024
 */
@Composable
fun MovieListScreen(navController: NavController, viewModel: MovieListViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    println("girdi2")

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.movieList) {
                MovieListRow(movie = it) {

                }
            }
        }

        if (state.error.isNotBlank()) {
            ErrorText(text = state.error)
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}