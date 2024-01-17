package com.example.notesapp


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesapp.component.TextField
import com.example.notesapp.component.TopBar
import com.example.notesapp.data.Data
import com.example.notesapp.data.DataColumn


@Composable

fun NoteScreen(
    noteList: List<Data>,
    noteAdd: (Data) -> Unit,
    removeNote: (Data) -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }


    Surface(modifier = Modifier.fillMaxWidth()) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            TopBar(modifier = Modifier.padding(bottom = 8.dp))

            TextField(
                textShow = title,
                onvalueChange = { it -> title = it },
                lable = "Title", placeHolder = "Enter Your Title",
                modifier = Modifier.padding(bottom = 8.dp)
            )


            TextField(
                textShow = description,
                onvalueChange = { it -> description = it },
                lable = "Description", placeHolder = "Enter Your Description",
                modifier = Modifier.padding(bottom = 9.dp)
            )

            Button(onClick = {
                //save the data

                if (description.isNotEmpty() && title.isNotEmpty()) {
                    noteAdd(Data(title = title, description = description))
                }

                //blank other field
                title = ""
                description = ""

            }) {

                Text(text = "Save")

            }

            Divider(modifier = Modifier.padding(12.dp))

            DataColumn(noteList, removeNote)


        }


    }


}