package com.example.notesapp.activities

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.notesapp.data.roomDataBase.Note
import java.time.format.DateTimeFormatter

@Composable


fun DataColumn(noteList: List<Note>, removeNote: (Note) -> Unit) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
    ) {

        items(noteList.size) {

            CardCreator(data = noteList[it], removeNote)

        }

    }

}


@Composable
private fun CardCreator(data: Note, removeNote: (Note) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 8.dp),
        shape = RoundedCornerShape(topEnd = 36.dp, bottomStart = 36.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = data.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )


                Icon(imageVector = Icons.Rounded.Delete, contentDescription = "",
                    modifier = Modifier.clickable { removeNote(data) })
            }



            Text(text = data.description)
            Spacer(modifier = Modifier.height(4.dp))

            Text(text = data.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy")), 
                style = MaterialTheme.typography.labelMedium,
                fontFamily = FontFamily.Cursive)


        }


    }
}



