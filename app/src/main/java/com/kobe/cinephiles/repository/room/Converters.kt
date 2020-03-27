package com.kobe.cinephiles.repository.room

import android.util.Log
import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun stringToList(value: String): List<Int> {
        val listInt = mutableListOf<Int>()

        if (value != "") {
            val listString = value.split(',')
            listString.forEach { s -> listInt.add(s.toInt()) }
        }

        return listInt
    }

    @TypeConverter
    fun listToString(list: List<Int>): String {
        val sb = StringBuffer()

        list.forEachIndexed { index, s ->
            if (index > 0) sb.append(',')
            sb.append(s)
        }

        return sb.toString()
    }
}