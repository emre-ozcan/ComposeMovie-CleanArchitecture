package com.emreozcan.composemovie.presentation.common

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by @Emre Özcan on 28.05.2024
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    actions: @Composable () -> Unit = {}
) {
    if (canNavigateBack) {
        TopAppBar(
            title = {
                Text(text = title)
            },
            actions = { actions() },
            navigationIcon = {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            modifier = modifier
        )
    } else {
        TopAppBar(
            title = {
                Text(text = title)
            },
            actions = { actions() },
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun NavTopBarPreviewBack() {
    TopBar(title = "Details", canNavigateBack = true)
}

@Preview
@Composable
fun NavTopBarPreview() {
    TopBar(title = "Details", canNavigateBack = false)
}