package com.example.musicassignmentapp.data.model.infoartist


import com.google.gson.annotations.SerializedName

data class Similar(
    @SerializedName("artist")
    val artist: List<ArtistX>
)