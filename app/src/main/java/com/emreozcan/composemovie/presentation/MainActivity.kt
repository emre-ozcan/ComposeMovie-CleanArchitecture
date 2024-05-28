package com.emreozcan.composemovie.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emreozcan.composemovie.presentation.movieDetail.MovieDetailScreen
import com.emreozcan.composemovie.presentation.movieList.views.MovieListScreen
import com.emreozcan.composemovie.presentation.theme.ComposeMovieTheme
import com.emreozcan.composemovie.utils.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMovieTheme {
                Scaffold {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.MovieListScreen.route
                    ) {
                        composable(route = Screens.MovieListScreen.route) {
                            MovieListScreen(navController = navController)
                        }
                        composable(route = Screens.MovieDetailScreen.route + "/{${IMDB_ID}}") {
                            MovieDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

