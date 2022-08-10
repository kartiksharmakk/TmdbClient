package com.example.tmdbclient.data.repository.artists.datasource

import com.example.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

//In clean architecture,
//
//we always use public interfaces to communicate between components .
//
//So we will start by creating 3 interfaces for RemoteDataSource, LocalDataSource and
//cache data source
interface ArtistsRemoteDataSource {
    suspend fun getArtists():Response<ArtistList>
}