package com.emreozcan.composemovie.presentation.movieList.views

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.emreozcan.composemovie.domain.model.MovieItemUiModel
import com.emreozcan.composemovie.presentation.theme.ComposeMovieTheme

/**
 * Created by @Emre Özcan on 28.05.2024
 */

@Composable
fun MovieListRow(
    movie: MovieItemUiModel, onItemClick: (String) -> Unit
) {
    ListItem(
        headlineContent = {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleLarge
            )
        },
        leadingContent = {
            AsyncImage(
                modifier = Modifier
                    .size(86.dp)
                    .clip(CircleShape),
                model = movie.poster,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        },
        supportingContent = {
            Text(text = movie.year, style = MaterialTheme.typography.bodyLarge)
        },
        modifier = Modifier.clickable {
            onItemClick(movie.imdbId)
        })
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MovieListRowPreview() {
    ComposeMovieTheme {
        MovieListRow(
            movie = MovieItemUiModel(
                poster = "https://m.media-amazon.com/images/M/MV5BYThjYzcyYzItNTVjNy00NDk0LTgwMWQtYjMwNmNlNWJhMzMyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
                title = "Batman",
                year = "2020",
                imdbId = "132"
            )
        ) {}
    }
}