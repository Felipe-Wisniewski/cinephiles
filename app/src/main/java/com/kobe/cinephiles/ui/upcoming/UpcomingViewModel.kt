package com.kobe.cinephiles.ui.upcoming

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kobe.cinephiles.model.UpcomingMovie
import com.kobe.cinephiles.repository.MovieRepositoryImpl
import com.kobe.cinephiles.repository.paging.UpcomingDataSourceFactory

class UpcomingViewModel(private val repository: MovieRepositoryImpl, sourceFactory: UpcomingDataSourceFactory) : ViewModel() {

    var moviesList: LiveData<PagedList<UpcomingMovie>>

    init {

        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .setPrefetchDistance(10)
            .setEnablePlaceholders(false)
            .build()

        moviesList = LivePagedListBuilder(sourceFactory, config)
            .build()

    }


}
