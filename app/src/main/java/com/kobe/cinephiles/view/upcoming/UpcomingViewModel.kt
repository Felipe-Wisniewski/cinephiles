package com.kobe.cinephiles.view.upcoming

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kobe.cinephiles.model.UpcomingMovie
import com.kobe.cinephiles.repository.MovieRepository
import com.kobe.cinephiles.repository.paging.UpcomingDataSourceFactory

class UpcomingViewModel(private val repository: MovieRepository,
                        val sourceFactory: UpcomingDataSourceFactory) : ViewModel() {

    private val moviesUpcoming: LiveData<PagedList<UpcomingMovie>>

    private val moviesFavorites: LiveData<List<UpcomingMovie>> = repository.loadFavorites()

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .setPrefetchDistance(10)
            .setEnablePlaceholders(false)
            .build()

        moviesUpcoming = LivePagedListBuilder(sourceFactory, config)
            .build()
    }

    fun getMoviesUpcoming(): LiveData<PagedList<UpcomingMovie>> {
        return moviesUpcoming
    }

    fun getMoviesFavorites(): LiveData<List<UpcomingMovie>> {
        return moviesFavorites
    }

    fun saveFavorite(movie: UpcomingMovie) {
        repository.saveFavorite(movie)
    }

    fun isFavorite(movie: UpcomingMovie): Boolean = repository.isFavorite(movie)

    fun deleteFavorite(movie: UpcomingMovie) {
        repository.deleteFavorite(movie)
    }
}
