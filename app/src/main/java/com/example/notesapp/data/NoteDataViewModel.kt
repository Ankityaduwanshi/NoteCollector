package com.example.notesapp.data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.roomDataBase.Note
import com.example.notesapp.reposetory.NoteReposetory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

// we can also use this view model but now i am not using its for only reference of upcoming application
@HiltViewModel
class NoteDataViewModel @Inject constructor(private val noteReposetory: NoteReposetory) :
    ViewModel() {
    private var pnotes = MutableStateFlow<List<Note>>(emptyList())

    val notes = pnotes.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteReposetory.getNotes().distinctUntilChanged().collect { list ->

                if (list.isEmpty()) {
                    pnotes.value= emptyList()
                } else {
                    pnotes.value = list
                }

            }
        }
    }


    fun noteAdd(note: Note) = viewModelScope.launch { noteReposetory.insert(note) }


    fun removeNote(note: Note) = viewModelScope.launch { noteReposetory.delete(note) }


}