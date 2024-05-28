package com.emreozcan.composemovie.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Created by @Emre Özcan on 28.05.2024
 */
@Composable
fun ErrorText(text: String) {
    Text(
        text = text, textAlign = TextAlign.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(
                14.dp
            )
    )
}