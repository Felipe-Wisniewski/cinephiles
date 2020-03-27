package com.kobe.cinephiles.repository.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kobe.cinephiles.model.Genre
import com.kobe.cinephiles.model.UpcomingMovie

@Dao
interface CineDao {

    @Insert(onConflict = REPLACE)
    fun saveFavorite(movie: UpcomingMovie)

    @Delete
    fun deleteFavorite(movie: UpcomingMovie)

    @Query("SELECT * FROM favorite")
    fun loadFavorite(): LiveData<List<UpcomingMovie>>

    @Query("SELECT * FROM favorite WHERE id = :id")
    fun movieById(id: Int): UpcomingMovie?

    @Insert(onConflict = REPLACE)
    fun saveGenre(genres: List<Genre>)

    @Query("SELECT * FROM genre")
    fun loadGenre(): LiveData<List<Genre>>

}