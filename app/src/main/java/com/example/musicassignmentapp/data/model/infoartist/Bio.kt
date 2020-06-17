package com.example.musicassignmentapp.data.model.infoartist


import com.google.gson.annotations.SerializedName

data class Bio(
    @SerializedName("content")
    val content: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("published")
    val published: String,
    @SerializedName("summary")
    val summary: String
)