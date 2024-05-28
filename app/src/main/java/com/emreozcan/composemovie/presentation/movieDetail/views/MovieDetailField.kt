package com.emreozcan.composemovie.presentation.movieDetail.views

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by @Emre Özcan on 28.05.2024
 */
@Composable
fun MovieDetailField(year: String, runtime: String, language: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp),

                imageVector = Icons.Default.DateRange, contentDescription = null
            )
            Text(text = year)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp),
                imageVector = Icons.Default.Info,
                contentDescription = null
            )
            Text(text = runtime)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp),
                imageVector = Icons.Default.Menu,
                contentDescription = null
            )
            Text(text = language)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailFieldPreview() {
    MovieDetailField("2020", "120min", "English")
}