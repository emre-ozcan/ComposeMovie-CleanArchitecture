package com.emreozcan.composemovie.domain.useCase.movieList

import com.emreozcan.composemovie.data.mapper.MovieMapper
import com.emreozcan.composemovie.domain.model.MovieItemUiModel
import com.emreozcan.composemovie.domain.repository.MovieListRepository
import com.emreozcan.composemovie.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 27.05.2024
 */
class GetMovieListUseCase @Inject constructor(private val repository: MovieListRepository) {

    companion object {
        const val SUCCESS = "True"
    }

    operator fun invoke(search: String): Flow<Resource<List<MovieItemUiModel>>> = flow {
        try {
            emit(Resource.Loading())
            val movieListDtoResponse = repository.getMovieList(search)

            if (movieListDtoResponse.response == SUCCESS) {
                val items = movieListDtoResponse.movieListItems?.map { MovieMapper.movieListDtoToMovieItemUiModel(it)}?.toList() ?: emptyList()
                emit(Resource.Success(items))
            } else {
                emit(Resource.Error(message = "No movie found :("))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred :/"))
        }
    }
}