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

    @Query("SELECT * FROM $TABLE_FAVORITE")
    fun loadFavorite(): LiveData<List<UpcomingMovie>>

    @Query("SELECT * FROM $TABLE_FAVORITE WHERE id LIKE :id")
    fun movieById(id: Int): List<UpcomingMovie>

    @Insert(onConflict = REPLACE)
    fun saveGenre(genres: List<Genre>)

    @Query("SELECT * FROM $TABLE_GENRE")
    fun loadGenre(): LiveData<List<Genre>>

}