package com.example.tmdbclient.data.repository.movies.datasource

import com.example.tmdbclient.data.model.artist.Artist

interface ArtistsCacheDataSource {
    suspend fun saveArtistsToCache(artists:List<Artist>)
    suspend fun getArtistsFromCache():List<Artist>
}