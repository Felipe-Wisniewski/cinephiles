package com.kobe.cinephiles.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kobe.cinephiles.repository.room.TABLE_FAVORITE
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TABLE_FAVORITE)
data class UpcomingMovie(@PrimaryKey val id: Int,
                         val title: String,
                         var poster_path: String,
                         val genre_ids: List<Int>,
                         val vote_average: Float,
                         val release_date: String) : Parcelable