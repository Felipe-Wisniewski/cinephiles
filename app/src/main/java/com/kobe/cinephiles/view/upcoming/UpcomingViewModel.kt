package com.kobe.cinephiles.view.upcoming

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kobe.cinephiles.model.UpcomingMovie
import com.kobe.cinephiles.repository.MovieRepository
import com.kobe.cinephiles.repository.paging.UpcomingDataSourceFactory

class UpcomingViewModel(private val repository: MovieRepository, val sourceFactory: UpcomingDataSourceFactory) : ViewModel() {

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

    val moviesFavorites: LiveData<List<UpcomingMovie>> = repository.loadFavorites()


    fun saveFavorite(movie: UpcomingMovie) {
        repository.saveFavorite(movie)
    }

    fun isFavorite(movie: UpcomingMovie): Boolean = repository.isFavorite(movie)

    fun deleteFavorite(movie: UpcomingMovie) {
        repository.deleteFavorite(movie)
    }
}
