package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.domain.repository.ArtistsRepository
import com.example.tmdbclient.domain.repository.MoviesRepository
import com.example.tmdbclient.domain.repository.TvShowsRepository
import com.example.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetArtistsUseCase(
        artistsRepository: ArtistsRepository
    ):GetArtistsUseCase{
        return GetArtistsUseCase(artistsRepository)
    }
    @Singleton
    @Provides
    fun provideGetMoviesUseCase(
        moviesRepository: MoviesRepository
    ): GetMoviesUseCase {
        return GetMoviesUseCase(moviesRepository)
    }
    @Singleton
    @Provides
    fun provideGetTvShowsUseCase(
        tvShowsRepository: TvShowsRepository
    ):GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowsRepository)
    }
    @Singleton
    @Provides
    fun provideUpdateArtistsUseCase(
        artistsRepository: ArtistsRepository
    ): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistsRepository)
    }
    @Singleton
    @Provides
    fun provideUpdateMoviesUseCase(
        moviesRepository: MoviesRepository
    ): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(moviesRepository)
    }
    @Singleton
    @Provides
    fun provideUpdateTvShowsUseCase(
        tvShowsRepository: TvShowsRepository
    ): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowsRepository)
    }
}