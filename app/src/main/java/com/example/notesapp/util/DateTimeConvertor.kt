package com.example.notesapp.util

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Date

class DateTimeConvertor {

    @TypeConverter
    fun longFromDate(date: LocalDateTime):Long{
        return date.toEpochSecond(ZoneOffset.UTC)
    }

    @TypeConverter
    fun dateFromLong(longDate:Long):LocalDateTime{
        val instant = Instant.ofEpochSecond(longDate)

        return LocalDateTime.ofInstant(instant,ZoneOffset.UTC)
    }
}