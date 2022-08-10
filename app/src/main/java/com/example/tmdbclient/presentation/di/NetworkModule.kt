package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
/*
With dagger hilt, we already have components created for us, so there's
no need for components in the di package layer here.

All we need to do is install in. Hilt modules must be annotated with
@InstallIn to tell Hilt which Android class each module will be used or
installed in.
 */


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /*
    Get a retrofit instance.
     */
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }
    /*
    Return an instance of TMDBService.
     */
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit):TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}