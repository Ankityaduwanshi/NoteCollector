package com.example.notesapp.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Text field
@Composable
fun TextField(modifier: Modifier = Modifier,
              textShow: String,
              maxline:Int = 3,
              onvalueChange: (String)->Unit,
              lable : String ,
              placeHolder: String,
              imeAction: ImeAction = ImeAction.Default,){

    TextField(value = textShow,
        onValueChange =onvalueChange,
        label = {Text(text = lable)},
        placeholder = { Text(text = placeHolder)},
        keyboardOptions = KeyboardOptions().copy(imeAction = imeAction),
        colors = TextFieldDefaults.colors(focusedContainerColor = Color.Transparent, unfocusedContainerColor = Color.Transparent),
        maxLines = maxline ,
        modifier = modifier

    )

}









//Top bar
@Preview
@Composable
fun TopBar(modifier: Modifier = Modifier){

    Surface (modifier = modifier
        .fillMaxWidth()
        .height(56.dp),
        color = MaterialTheme.colorScheme.primaryContainer){

        Row (modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){

            Text(text = "NoteCollector",
                style = MaterialTheme.typography.headlineLarge,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold)

            Icon(imageVector = Icons.Rounded.Home, contentDescription = "")

        }

    }
}

