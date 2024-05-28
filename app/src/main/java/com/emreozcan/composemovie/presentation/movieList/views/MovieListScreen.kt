package com.emreozcan.composemovie.presentation.movieList.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.emreozcan.composemovie.presentation.Screens
import com.emreozcan.composemovie.presentation.common.ErrorText
import com.emreozcan.composemovie.presentation.common.ProgressBar
import com.emreozcan.composemovie.presentation.movieList.MovieListEvents
import com.emreozcan.composemovie.presentation.movieList.MovieListViewModel

/**
 * Created by @Emre Özcan on 27.05.2024
 */
@Composable
fun MovieListScreen(navController: NavController, viewModel: MovieListViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        MovieSearchBar(onSearch = {
            viewModel.onEvent(MovieListEvents.Search(it))
        }) {
            when {
                state.isLoading -> {
                    ProgressBar()
                }

                state.error.isNotBlank() -> {
                    ErrorText(text = state.error)
                }

                state.movieList.isNotEmpty() -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(state.movieList) {
                            MovieListRow(movie = it) { imdbId ->
                                navController.navigate(Screens.MovieDetailScreen.route + "/$imdbId")
                            }
                        }
                    }
                }
            }
        }
    }
}