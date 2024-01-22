package com.example.notesapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.data.roomDataBase.NoteDataBase
import com.example.notesapp.data.roomDataBase.NoteDataBaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object appModule {

    // these functions we not use in code these are automatically used when app is running to provide access
    // of app storage and create a actual database on it

    @Singleton
    @Provides
    fun provideNotesDao (noteDataBase :NoteDataBase): NoteDataBaseDao = noteDataBase.noteDao()


    @Singleton
    @Provides
    fun provideAppDataBase (@ApplicationContext context : Context) : NoteDataBase = Room.databaseBuilder(
        context = context,
        klass = NoteDataBase::class.java,
        name = "Notes_Database"
    ).fallbackToDestructiveMigration().build()
}