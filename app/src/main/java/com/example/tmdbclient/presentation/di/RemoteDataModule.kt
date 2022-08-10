package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.ArtistsRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.artists.datasource.ArtistsRemoteDataSource
import com.example.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.movies.datasource.MovieRemoteDatasource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/*
   Method to provide the remote data source with its dependencies.

   It takes our api service as a parameter because its a parameter in the
   actual data source class.

   We always use the implementation class.
    */
@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(
        tmdbService: TMDBService,
        apiKey:String
    ): ArtistsRemoteDataSource {
        return ArtistsRemoteDataSourceImpl(tmdbService,apiKey)
    }
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(
        tmdbService: TMDBService,
        apiKey :String
    ): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }
    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(
        tmdbService: TMDBService,
        apiKey:String
    ): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(tmdbService,apiKey)
    }
}