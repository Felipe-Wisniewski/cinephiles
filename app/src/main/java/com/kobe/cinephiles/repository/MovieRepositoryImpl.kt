package com.kobe.cinephiles.repository

import androidx.lifecycle.LiveData
import com.kobe.cinephiles.model.MovieGenre
import com.kobe.cinephiles.model.UpcomingMovie
import com.kobe.cinephiles.repository.retrofit.HttpService

class MovieRepositoryImpl(private val service: HttpService) : MovieRepository {

    override fun getUpcomingMovies(): LiveData<List<UpcomingMovie>> {
        TODO("Not yet implemented")
    }

    override fun getMoviesGenre(): LiveData<List<MovieGenre>> {
        TODO("Not yet implemented")
    }
}