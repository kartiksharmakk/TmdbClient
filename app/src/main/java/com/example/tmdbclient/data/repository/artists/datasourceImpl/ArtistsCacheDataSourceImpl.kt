package com.example.tmdbclient.data.repository.movies.datasourceImpl

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repository.movies.datasource.ArtistsCacheDataSource

class ArtistsCacheDataSourceImpl: ArtistsCacheDataSource {
    private var artistList =ArrayList<Artist>()
    override suspend fun saveArtistsToCache(artists: List<Artist>) {
         artistList.clear()
        artistList= ArrayList(artists)
    }

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }
}