package com.example.tmdbclient.data.repository

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.repository.artists.datasource.ArtistsRemoteDataSource
import retrofit2.Response

class ArtistsRemoteDataSourceImpl(private val tmdbService: TMDBService
,private val apiKey:String): ArtistsRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList>
    =tmdbService.getPopularArtists(apiKey)
}