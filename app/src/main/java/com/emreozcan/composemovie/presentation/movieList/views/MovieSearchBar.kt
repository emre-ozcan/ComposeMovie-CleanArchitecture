package com.emreozcan.composemovie.presentation.movieList.views

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by @Emre Özcan on 28.05.2024
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchBar(
    onSearch: (String) -> Unit = {},
    body: @Composable () -> Unit
) {
    
    var text by remember { mutableStateOf("") }
    var showClearIcon by remember {
        mutableStateOf(false)
    }

    SearchBar(query = text,
        onQueryChange = {
            showClearIcon = text.isNotBlank() && text.isNotEmpty()
            text = it
        },
        onSearch = {
            onSearch(it)
        },
        active = true,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            if (showClearIcon) {
                Icon(modifier = Modifier.clickable {
                    showClearIcon = false
                    text = ""
                    onSearch("Superman")
                }, imageVector = Icons.Default.Close, contentDescription = null)
            }
        },
        onActiveChange = {}) {
        body()
    }
}

@Preview
@Composable
fun MovieSearchBarPreview() {
    MovieSearchBar(onSearch = {}, {})
}