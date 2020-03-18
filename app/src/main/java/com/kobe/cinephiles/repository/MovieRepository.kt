package com.kobe.cinephiles.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kobe.cinephiles.model.Genre
import com.kobe.cinephiles.model.UpcomingMovie

interface MovieRepository {
    fun getMoviesGenre(): LiveData<List<Genre>>
}