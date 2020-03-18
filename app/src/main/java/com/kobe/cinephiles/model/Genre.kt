package com.kobe.cinephiles.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kobe.cinephiles.repository.room.TABLE_GENRE

@Entity(tableName = TABLE_GENRE)
data class Genre(@PrimaryKey val id: Int, val name: String)