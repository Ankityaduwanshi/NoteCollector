package com.example.notesapp.data.roomDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notesapp.util.DateTimeConvertor
import com.example.notesapp.util.UUIDconvertor

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateTimeConvertor::class,UUIDconvertor::class)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao():NoteDataBaseDao
}