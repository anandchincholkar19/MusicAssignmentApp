package com.example.musicassignmentapp.data.model


import com.google.gson.annotations.SerializedName

data class AlbumX(
    @SerializedName("artist")
    val artist: String,
    @SerializedName("image")
    val image: List<Image>,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("streamable")
    val streamable: String,
    @SerializedName("url")
    val url: String
)