package com.example.tmdbclient.data.repository.movies

import android.util.Log
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repository.movies.datasource.ArtistsCacheDataSource
import com.example.tmdbclient.data.repository.movies.datasource.ArtistsLocalDataSource
import com.example.tmdbclient.data.repository.artists.datasource.ArtistsRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistsRepository

class ArtistsRepositoryImpl(private val artistsCacheDataSource: ArtistsCacheDataSource
                            , private val artistsLocalDataSource: ArtistsLocalDataSource
                            , private val artistsRemoteDataSource: ArtistsRemoteDataSource
) : ArtistsRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistsLocalDataSource.clearAllArtistsFromDB()
        artistsLocalDataSource.saveArtiststoDB(newListOfArtists)
        artistsCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }
    //Since we are going to call to functions which use coroutines,we need to write these functions as suspending functions. Return type is a list of movies. Let’s declare a list for the movies. We will assign the movies taken from the api to this list. And we will return it. For the exception handling ,let’s add a try catch block.
    suspend fun getArtistsFromAPI() : List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistsRemoteDataSource.getArtists()
            val body=response.body()
            if(body!=null){
                artistList=body.artists
            }
        }catch (exception:Exception){
            Log.i("Mytag",exception.message.toString())
        }
        return artistList
    }
    suspend fun getArtistsFromDB() : List<Artist> {
        lateinit var artistList: List<Artist>
        try {
                artistList=artistsLocalDataSource.getArtistsFromDB()
        }
        catch (exception:Exception){
            Log.i("Mytag",exception.message.toString())
        }
        if(artistList.size>0){
        return artistList
        }
        else
        {
            artistList=getArtistsFromAPI()
            artistsLocalDataSource.saveArtiststoDB(artistList)
        }
        return artistList
    }
    suspend fun getArtistsFromCache() : List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList=artistsCacheDataSource.getArtistsFromCache()
        }
        catch (exception:Exception){

            Log.i("Mytag",exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }
        else
        {
            artistList=getArtistsFromDB()
            artistsCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}