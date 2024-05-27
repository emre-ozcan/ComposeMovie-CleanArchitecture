package com.emreozcan.composemovie.data.di

import com.emreozcan.composemovie.data.remote.service.MovieService
import com.emreozcan.composemovie.data.repository.MovieDetailRepositoryImpl
import com.emreozcan.composemovie.data.repository.MovieListRepositoryImpl
import com.emreozcan.composemovie.domain.repository.MovieDetailRepository
import com.emreozcan.composemovie.domain.repository.MovieListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by @Emre Özcan on 27.05.2024
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieListRepository(service: MovieService): MovieListRepository {
        return MovieListRepositoryImpl(service)
    }

    @Singleton
    @Provides
    fun provideMovieDetailRepository(service: MovieService): MovieDetailRepository {
        return MovieDetailRepositoryImpl(service)
    }
}