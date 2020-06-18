package com.example.musicassignmentapp.data.model.infoartist


import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("bio")
    val bio: Bio,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)