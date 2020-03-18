package com.kobe.cinephiles.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kobe.cinephiles.repository.room.TABLE_FAVORITE

@Entity(tableName = TABLE_FAVORITE)
data class Movie(
    @PrimaryKey val id: Int,
    val title: String,
    val poster_path: String,
    val backdrop_path: String,
    val genre: String,
    val vote_average: Float,
    val release_date: String
)