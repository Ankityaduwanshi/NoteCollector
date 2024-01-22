package com.example.notesapp.util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDconvertor {

    @TypeConverter
    fun stringFromUUID(uuid: UUID):String{

        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String?):UUID?{

        return UUID.fromString(string)

    }
}