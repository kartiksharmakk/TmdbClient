package com.example.tmdbclient.presentation.tv

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.room.CoroutinesRoom.Companion.execute
import com.example.tmdbclient.data.model.tvshow.TvShowList
import com.example.tmdbclient.domain.usecase.*

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val TvShowList =getTvShowsUseCase.execute()
        emit(TvShowList)
    }

    fun updateTvShows() = liveData {
        val TvShowList = updateTvShowsUseCase.execute()
        emit(TvShowList)
    }
}