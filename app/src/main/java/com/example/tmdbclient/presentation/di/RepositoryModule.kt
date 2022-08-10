package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.repository.artists.datasource.ArtistsRemoteDataSource
import com.example.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movies.ArtistsRepositoryImpl
import com.example.tmdbclient.data.repository.movies.datasource.ArtistsCacheDataSource
import com.example.tmdbclient.data.repository.movies.datasource.ArtistsLocalDataSource
import com.example.tmdbclient.data.repository.movies.datasource.MovieRemoteDatasource
import com.example.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdbclient.domain.repository.ArtistsRepository
import com.example.tmdbclient.domain.repository.MoviesRepository
import com.example.tmdbclient.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/*
Class to provide dependencies to our repository modules.
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {


    /*
    Provide our news repository with its dependencies.
     */
    @Singleton
    @Provides
    fun provideArtistRepository(
        artistsCacheDataSource: ArtistsCacheDataSource,
        artistsLocalDataSource: ArtistsLocalDataSource,
        artistsRemoteDataSource: ArtistsRemoteDataSource
    ): ArtistsRepository {
        return ArtistsRepositoryImpl(artistsCacheDataSource,artistsLocalDataSource,artistsRemoteDataSource)
    }
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDatasource: MovieRemoteDatasource
    ): MoviesRepository {
        return MovieRepositoryImpl(movieRemoteDatasource,movieLocalDataSource,movieCacheDataSource)
    }
    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowRemoteDatasource: TvShowRemoteDatasource
    ): TvShowsRepository {
        return TvShowRepositoryImpl(tvShowRemoteDatasource,tvShowLocalDataSource,tvShowCacheDataSource)
    }
}