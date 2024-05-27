package com.emreozcan.composemovie.data.remote.dto.movieList


import com.google.gson.annotations.SerializedName

data class MovieListItem(
    @SerializedName("imdbID")
    val imdbID: String?,
    @SerializedName("Poster")
    val poster: String?,
    @SerializedName("Title")
    val title: String?,
    @SerializedName("Year")
    val year: String?
)