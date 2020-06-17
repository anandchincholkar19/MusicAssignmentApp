package com.example.musicassignmentapp.data.model.infoartist


import com.google.gson.annotations.SerializedName

data class ImageX(
    @SerializedName("size")
    val size: String,
    @SerializedName("#text")
    val text: String
)