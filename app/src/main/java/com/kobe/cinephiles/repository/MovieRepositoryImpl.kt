package com.kobe.cinephiles.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kobe.cinephiles.model.Genre
import com.kobe.cinephiles.model.GenreResults
import com.kobe.cinephiles.model.UpcomingMovie
import com.kobe.cinephiles.model.UpcomingResults
import com.kobe.cinephiles.repository.retrofit.HttpService
import com.kobe.cinephiles.repository.room.CineDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepositoryImpl(private val service: HttpService,
                          private val cineDao: CineDao) : MovieRepository {

    override fun saveFavorite(movie: UpcomingMovie) {
        cineDao.saveFavorite(movie)
    }

    override fun loadFavorites(): LiveData<List<UpcomingMovie>> {
        return cineDao.loadFavorite()
    }

    override fun isFavorite(movie: UpcomingMovie): Boolean {
        return cineDao.movieById(movie.id).isNotEmpty()
    }

    override fun deleteFavorite(movie: UpcomingMovie) {
        cineDao.deleteFavorite(movie)
    }

    override fun getMoviesGenre(): LiveData<List<Genre>> {
        val data = MutableLiveData<List<Genre>>()

        service.genreMovie().enqueue(object : Callback<GenreResults> {
            override fun onResponse(call: Call<GenreResults>, response: Response<GenreResults>) {
                data.value = response.body()?.genres
            }

            override fun onFailure(call: Call<GenreResults>, t: Throwable) {
                Log.e("FLMWG", "Error callback genres")
            }
        })

        return data
    }
}