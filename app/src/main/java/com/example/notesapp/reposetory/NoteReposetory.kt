package com.example.notesapp.reposetory

import com.example.notesapp.data.roomDataBase.Note
import com.example.notesapp.data.roomDataBase.NoteDataBaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteReposetory @Inject constructor(private val noteDataBaseDao : NoteDataBaseDao) {

    suspend fun insert (note: Note) = noteDataBaseDao.insert(note)

    suspend fun delete (note: Note) = noteDataBaseDao.delete(note)

    suspend fun update (note: Note) = noteDataBaseDao.update(note)

    fun getNotes(): Flow<List<Note>> = noteDataBaseDao.getNotes().flowOn(Dispatchers.IO).conflate()

}