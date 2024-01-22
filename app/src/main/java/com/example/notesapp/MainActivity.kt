package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notesapp.activities.NoteScreen
import com.example.notesapp.data.NoteDataViewModel
import com.example.notesapp.ui.theme.NotesAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteDataViewModel = viewModel<NoteDataViewModel>()
                    Start(noteDataViewModel)

                }
            }
        }
    }
}


@Composable
fun Start(noteDataViewModel: NoteDataViewModel) {


    NoteScreen(
        noteList = noteDataViewModel.notes.collectAsState().value,
        noteAdd = { noteDataViewModel.noteAdd(it) }
    ) { noteDataViewModel.removeNote(note = it) }


}



