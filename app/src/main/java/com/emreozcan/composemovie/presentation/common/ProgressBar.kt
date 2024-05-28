package com.emreozcan.composemovie.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by @Emre Özcan on 28.05.2024
 */
@Composable
fun ProgressBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun ProgressBarPreview() {
    ProgressBar()
}