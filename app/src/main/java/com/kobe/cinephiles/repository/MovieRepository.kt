package com.kobe.cinephiles.repository

import androidx.lifecycle.LiveData
import com.kobe.cinephiles.model.MovieGenre
import com.kobe.cinephiles.model.UpcomingMovie

interface MovieRepository {
    fun getUpcomingMovies(): LiveData<List<UpcomingMovie>>
    fun getMoviesGenre(): LiveData<List<MovieGenre>>
}