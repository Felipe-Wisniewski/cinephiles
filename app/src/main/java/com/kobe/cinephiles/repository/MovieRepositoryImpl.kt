package com.kobe.cinephiles.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kobe.cinephiles.model.Genre
import com.kobe.cinephiles.model.GenreResults
import com.kobe.cinephiles.model.UpcomingMovie
import com.kobe.cinephiles.model.UpcomingResults
import com.kobe.cinephiles.repository.retrofit.HttpService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepositoryImpl(private val service: HttpService) : MovieRepository {

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