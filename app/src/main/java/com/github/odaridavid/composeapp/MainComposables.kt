package com.github.odaridavid.composeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview


@Composable
fun NewsStory() {

    val image = imageResource(id = R.drawable.header)
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            val typography = MaterialTheme.typography

            val imageModifier =
                Modifier.preferredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))

            Image(image, modifier = imageModifier, contentScale = ContentScale.Crop)

            Spacer(Modifier.preferredHeight(16.dp))

            Text(
                text = "5 Tips for Your Next Holiday",
                style = typography.h5,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "David Odari",
                style = typography.subtitle1,
                color = Color.Blue
            )
            Text(
                text = "So its that time again you have to do this x,yz, and haha then another hah",
                style = typography.body1
            )
            Text(
                text = "12th September 2020",
                style = typography.caption,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsStoryPreview() {
    NewsStory()
}