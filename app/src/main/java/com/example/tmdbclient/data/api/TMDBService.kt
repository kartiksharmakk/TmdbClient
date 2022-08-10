package com.example.tmdbclient.data.api

import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query
            ("api_key")
        apiKey:String): Response<MovieList>

    @GET("3/tv/popular")
    suspend fun getPopularTvShows(
        @Query
            ("api_key")
        apiKey:String): Response<TvShowList>

    @GET("3/person/popular")
    suspend fun getPopularArtists(
        @Query
            ("api_key")
        apiKey:String): Response<ArtistList>

}