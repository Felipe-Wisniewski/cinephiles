package com.kobe.cinephiles.repository.retrofit

import com.kobe.cinephiles.model.UpcomingResults
import retrofit2.Call
import retrofit2.http.GET

interface HttpService {

    @GET("movie/upcoming")
    fun upcomingMovies() : Call<UpcomingResults>

    @GET("genre/movie/list")
    fun genreMovie()
}