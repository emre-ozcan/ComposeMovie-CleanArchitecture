package com.emreozcan.composemovie.presentation.movieDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreozcan.composemovie.domain.useCase.movieDetail.GetMovieDetailUseCase
import com.emreozcan.composemovie.utils.Constants.IMDB_ID
import com.emreozcan.composemovie.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 28.05.2024
 */
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: GetMovieDetailUseCase,
    private val savedstateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state

    init {
        savedstateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }

    private fun getMovieDetail(imdbId: String) {
        movieDetailUseCase.invoke(imdbId = imdbId).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(movie = it.data)
                }

                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message ?: "Error!")

                }

                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}