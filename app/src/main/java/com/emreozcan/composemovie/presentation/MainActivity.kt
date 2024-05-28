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
import com.emreozcan.composemovie.presentation.movieList.views.MovieListScreen
import com.emreozcan.composemovie.presentation.theme.ComposeMovieTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        composable(route = Screens.MovieDetailScreen.route) {

                        }
                    }
                }
            }
        }
    }
}

