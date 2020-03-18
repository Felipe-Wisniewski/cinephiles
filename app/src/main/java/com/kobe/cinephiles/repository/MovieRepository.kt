package com.kobe.cinephiles.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kobe.cinephiles.model.Genre
import com.kobe.cinephiles.model.UpcomingMovie

interface MovieRepository {
    fun saveFavorite(movie: UpcomingMovie)
    fun loadFavorites(): LiveData<List<UpcomingMovie>>
    fun isFavorite(movie: UpcomingMovie): Boolean
    fun deleteFavorite(movie: UpcomingMovie)
    fun getMoviesGenre(): LiveData<List<Genre>>
}