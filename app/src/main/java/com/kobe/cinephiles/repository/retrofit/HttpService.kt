package com.kobe.cinephiles.repository.retrofit

import com.kobe.cinephiles.model.GenreResults
import com.kobe.cinephiles.model.UpcomingResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HttpService {

    @GET("movie/upcoming")
    fun upcomingMovies(@Query("page") page: Int) : Call<UpcomingResults>

    @GET("genre/movie/list")
    fun genreMovie() : Call<GenreResults>

}