package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.domain.repository.MoviesRepository

class UpdateMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute():List<Movie>?=moviesRepository.updateMovies()
}