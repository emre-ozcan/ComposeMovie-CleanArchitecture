package com.emreozcan.composemovie.domain.useCase.movieDetail

import com.emreozcan.composemovie.data.mapper.MovieMapper
import com.emreozcan.composemovie.data.remote.service.MovieService
import com.emreozcan.composemovie.domain.model.MovieDetailUiModel
import com.emreozcan.composemovie.domain.model.MovieItemUiModel
import com.emreozcan.composemovie.domain.repository.MovieDetailRepository
import com.emreozcan.composemovie.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 27.05.2024
 */
class GetMovieDetailUseCase @Inject constructor(private val repository: MovieDetailRepository) {

    companion object {
        const val SUCCESS = "True"
    }

    operator fun invoke(imdbId: String): Flow<Resource<MovieDetailUiModel>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetailDtoResponse = repository.getMovieDetail(imdbId)

            if (movieDetailDtoResponse.response == SUCCESS) {
                val item = MovieMapper.movieDetailDtoToMovieDetailUiModel(movieDetailDtoResponse)
                emit(Resource.Success(item))
            } else {
                emit(Resource.Error(message = "Movie details could not found :("))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred :/"))
        }
    }
}