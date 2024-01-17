package com.example.notesapp.data

import androidx.lifecycle.ViewModel

// we can also use this view model but now i am not using its for only reference of upcoming application

class NoteDataViewModel : ViewModel(){
    val note = mutableListOf<Data>()    //We use mutableListOf in place of val note = remember {mutableStateListOf<Data>() }

    fun NoteAdd(data:Data){
        note.add(data)
    }


    fun removeNote(data: Data) {
        note.remove(data)
    }



}