package com.kobe.cinephiles.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kobe.cinephiles.model.Genre
import com.kobe.cinephiles.model.UpcomingMovie

@Database(entities = [UpcomingMovie::class, Genre::class],
    version = DATABASE_VERSION, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CineDatabase : RoomDatabase() {

    abstract val cineDao: CineDao

    companion object {

        @Volatile
        private var INSTANCE: CineDatabase? = null

        fun getInstance(context: Context): CineDatabase {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {

                    instance = Room.databaseBuilder(context.applicationContext,
                            CineDatabase::class.java,
                            DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}