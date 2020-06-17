package com.example.musicassignmentapp.data.model.infoartist


import com.google.gson.annotations.SerializedName

data class Artistinfo(
    @SerializedName("artist")
    val artist: Artist
)