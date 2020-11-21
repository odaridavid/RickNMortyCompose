package com.github.odaridavid.ricknmorty.features.allcharacters.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.odaridavid.ricknmorty.models.Character
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun AllCharactersScreen(characters: List<Character>) {
    val context = ContextAmbient.current
    LazyColumnForIndexed(items = characters) { _, character ->
        CharacterItem(character = character) {
            Toast.makeText(context, character.name, Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
private fun CharacterItem(
    character: Character,
    onClick: () -> Unit
) {

//    val image = imageResource(id = R.drawable.header)
    MaterialTheme {
        Column(
            modifier = Modifier.clickable(onClick = onClick)
                .padding(16.dp)
        ) {

            val typography = MaterialTheme.typography

            val imageModifier =
                Modifier.preferredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))
//
//            Image(character.image, modifier = imageModifier, contentScale = ContentScale.Crop)

            CoilImage(
                data = character.image.toString(),
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.preferredHeight(16.dp))

            Text(
                text = "${character.name}",
                style = typography.h5,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
//            Text(
//                text = "David Odari",
//                style = typography.subtitle1,
//                color = Color.Blue
//            )
//            Text(
//                text = "So its that time again you have to do this x,yz, and haha then another hah",
//                style = typography.body1
//            )
//            Text(
//                text = "12th September 2020",
//                style = typography.caption,
//                color = Color.Gray
//            )
//            Button(onClick = {}) {
//                Row {
//                    Icon(asset = Icons.Rounded.Clear)
//                    Text(text = "Button", textAlign = TextAlign.Center)
//                }
//            }
//
//            IconButton(onClick = {}, icon = { Icon(asset = Icons.Default.Place) })
        }
    }
}
