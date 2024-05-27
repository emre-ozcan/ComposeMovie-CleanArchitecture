package com.emreozcan.composemovie.data.remote.dto.movieList


import com.google.gson.annotations.SerializedName

data class MovieListDto(
    @SerializedName("Response")
    val response: String?,
    @SerializedName("Search")
    val movieListItems: List<MovieListItem?>?
)