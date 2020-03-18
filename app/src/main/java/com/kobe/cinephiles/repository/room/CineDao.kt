package com.kobe.cinephiles.repository.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kobe.cinephiles.model.Genre
import com.kobe.cinephiles.model.Movie

@Dao
interface CineDao {

    @Insert(onConflict = REPLACE)
    fun saveFavorite(movie: Movie?)

    @Query("SELECT * FROM $TABLE_FAVORITE")
    fun loadFavorite(): LiveData<List<Movie>>

    @Insert(onConflict = REPLACE)
    fun saveGenre(genres: List<Genre>?)

    @Query("SELECT * FROM $TABLE_GENRE")
    fun loadGenre(): LiveData<List<Genre>>

}