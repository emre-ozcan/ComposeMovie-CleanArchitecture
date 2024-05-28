package com.emreozcan.composemovie.presentation.movieDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.emreozcan.composemovie.presentation.Screens
import com.emreozcan.composemovie.presentation.common.ErrorText
import com.emreozcan.composemovie.presentation.common.ProgressBar
import com.emreozcan.composemovie.presentation.common.TopBar
import com.emreozcan.composemovie.presentation.movieDetail.views.MovieDetailField
import com.emreozcan.composemovie.presentation.movieList.views.MovieListRow

/**
 * Created by @Emre Özcan on 28.05.2024
 */

@Composable
fun MovieDetailScreen(navController: NavController, movieDetailViewModel: MovieDetailViewModel = hiltViewModel()) {
    val state = movieDetailViewModel.state.value

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(title = "Details", canNavigateBack = true, navigateUp = {
            navController.popBackStack()
        })
        Box(modifier = Modifier.fillMaxSize()) {
            when {
                state.isLoading -> {
                    ProgressBar()
                }

                state.error.isNotBlank() -> {
                    ErrorText(text = state.error)
                }

                state.movie != null -> {
                    Column(modifier = Modifier.fillMaxSize()) {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.4f),

                            model = state.movie.poster,
                            contentScale = ContentScale.FillWidth,
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = state.movie.title,
                            style = MaterialTheme.typography.headlineLarge,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        MovieDetailField(year = state.movie.year, runtime = state.movie.runtime, language = state.movie.language)
                        Text(modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp), text = state.movie.plot)
                    }
                }
            }
        }
    }
}