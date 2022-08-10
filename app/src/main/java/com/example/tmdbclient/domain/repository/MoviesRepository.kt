package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.movie.Movie

interface MoviesRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}