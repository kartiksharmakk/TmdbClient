package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TvShowDao
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.repository.movies.datasource.ArtistsLocalDataSource
import com.example.tmdbclient.data.repository.movies.datasourceImpl.ArtistsLocalDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Now we need to create methods to provide our DATA SOURCES in our repository
 * layer with their dependencies.
 *
 * We have 3 data sources so we need a DI class for each one.
 */
@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    /**
     * Now we need to create methods to provide our DATA SOURCES in our repository
     * layer with their dependencies.
     *
     * We are going to return however, an instance of their IMPLEMENTATION (IMPL).
     *
     * We have 3 data sources so we need a DI class for each one.
     *
     * And in this layer, the LOCAL data source has a DAO as a parameter for each
     * individual one.
     */
    @Singleton
    @Provides
    fun provideArtistLocalDataSource(
        artistDao: ArtistDao
    ): ArtistsLocalDataSource {
        return ArtistsLocalDataSourceImpl(artistDao)
    }
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao)
            : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(
        tvShowDao: TvShowDao
    ): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}