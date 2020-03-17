package com.kobe.cinephiles.model

data class UpcomingMovie(val id: Int,
                         val title: String,
                         val poster_path: String?,
                         val backdrop_path: String?,
                         val genre_ids: List<Int>,
                         val vote_average: Float,
                         val release_date: String)