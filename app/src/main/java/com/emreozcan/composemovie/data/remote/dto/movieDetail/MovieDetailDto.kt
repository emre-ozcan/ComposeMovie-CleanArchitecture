package com.emreozcan.composemovie.data.remote.dto.movieDetail


import com.google.gson.annotations.SerializedName

data class MovieDetailDto(
    @SerializedName("imdbID")
    val imdbID: String?,
    @SerializedName("imdbRating")
    val imdbRating: String?,
    @SerializedName("Language")
    val language: String?,
    @SerializedName("Poster")
    val poster: String?,
    @SerializedName("Released")
    val released: String?,
    @SerializedName("Response")
    val response: String?,
    @SerializedName("Runtime")
    val runtime: String?,
    @SerializedName("Title")
    val title: String?,
    @SerializedName("Type")
    val type: String?,
    @SerializedName("Year")
    val year: String?,
    @SerializedName("Plot")
    val plot: String?
)