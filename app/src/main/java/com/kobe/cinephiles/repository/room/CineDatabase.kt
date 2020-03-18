package com.kobe.cinephiles.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kobe.cinephiles.model.Genre
import com.kobe.cinephiles.model.UpcomingMovie

@Database(entities = [UpcomingMovie::class, Genre::class], version = DATABASE_VERSION)
@TypeConverters(Converters::class)
abstract class CineDatabase : RoomDatabase() {

    abstract fun cineDao(): CineDao

    companion object {
        private var instance: CineDatabase? = null

        fun getDataBase(context: Context): CineDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                    CineDatabase::class.java,
                    DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build()
            }

            return instance as CineDatabase
        }

        fun destroyInstance() {
            instance = null
        }
    }
}