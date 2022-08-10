package com.example.tmdbclient.data.repository.movies.datasourceImpl

import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repository.movies.datasource.ArtistsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistsLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistsLocalDataSource {

    //When we are getting data from the room database, room execute that query in a back ground thread.
    //So we don’t need to explicitly write codes for background processing. But, we need to invoke other dao
    //functions from a back ground thread. We will use coroutines for that.
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getAllArtists()
    }

    //To run this in a background worker thread, I am using Dispatcher.IO.
    override suspend fun saveArtiststoDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
             artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAllArtistsFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}