package com.example.tmdbclient.presentation.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Now we are using dagger for dependency injection with our database.
 */
@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    /**
     * Method to provide our dependencies to our database layer of our app.
     *
     * And of course we want to provide single instances every time.
     */

    @Singleton
    @Provides
    fun provideMovieDataBase(app: Application):TMDBDatabase{
        return Room.databaseBuilder(app,TMDBDatabase::class.java,"tmdbclient")
            .build()
    }
    /**
     * We have 3 DAO INTERFACES in this project and our local data source needs them as
     * dependencies.
     *
     * So we will create methods to provide them with them now.
     *
     * And our database will be passed in as constructor to each one.
     *
     * And we will return an instance of each one.
     */

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvshowDao()
    }

    @Singleton
    @Provides
    fun provideActorDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }
}