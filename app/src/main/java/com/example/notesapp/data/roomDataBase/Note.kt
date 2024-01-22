package com.example.notesapp.data.roomDataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.UUID

@Entity(tableName = "Notes_table")

data class Note(
    @PrimaryKey
    val id:UUID = UUID.randomUUID(),

    @ColumnInfo(name = "Notes_title")
    val title : String,

    @ColumnInfo(name = "Notes_description")
    val description : String,

    @ColumnInfo(name = "Notes_entryDate")
     val entryDate : LocalDateTime = LocalDateTime.now()
    ){

}
