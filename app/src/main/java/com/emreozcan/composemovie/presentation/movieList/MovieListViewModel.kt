package com.emreozcan.composemovie.presentation.movieList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreozcan.composemovie.domain.useCase.movieList.GetMovieListUseCase
import com.emreozcan.composemovie.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 27.05.2024
 */

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MovieListState())
    val state: State<MovieListState> = _state

    private var job: Job? = null

    init {
        getMovieList(_state.value.search)
    }

    fun onEvent(event: MovieListEvents) {
        when (event) {
            is MovieListEvents.Search -> {
                getMovieList(event.searchString)
            }
        }
    }

    private fun getMovieList(search: String) {
        job?.cancel()

        job = getMovieListUseCase.invoke(search).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = MovieListState(movieList = resource.data ?: emptyList())
                }

                is Resource.Loading -> {
                    _state.value = MovieListState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = MovieListState(error = resource.message ?: "An error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}