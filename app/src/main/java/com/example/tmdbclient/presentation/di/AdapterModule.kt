package com.example.tmdbclient.presentation.di

import com.anushka.tmdbclient.presentation.artist.ArtistAdapter
import com.anushka.tmdbclient.presentation.tv.TvAdapter
import com.example.tmdbclient.presentation.movie.MovieAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun provideArtistAdapter():ArtistAdapter{
        return ArtistAdapter()
    }
    @Singleton
    @Provides
    fun provideMovieAdapter(): MovieAdapter {
        return MovieAdapter()
    }
    @Singleton
    @Provides
    fun provideTvShowsAdapter():TvAdapter{
        return TvAdapter()
    }
}