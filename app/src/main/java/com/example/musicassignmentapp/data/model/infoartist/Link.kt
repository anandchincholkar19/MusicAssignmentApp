package com.example.musicassignmentapp.data.model.infoartist


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("href")
    val href: String,
    @SerializedName("rel")
    val rel: String,
    @SerializedName("#text")
    val text: String
)