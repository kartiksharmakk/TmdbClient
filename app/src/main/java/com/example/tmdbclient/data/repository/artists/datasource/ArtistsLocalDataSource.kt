package com.example.tmdbclient.data.repository.movies.datasource

import com.example.tmdbclient.data.model.artist.Artist

interface ArtistsLocalDataSource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtiststoDB(artists:List<Artist>)
    suspend fun clearAllArtistsFromDB()
}