package com.example.musicassignmentapp.data.model.searchalbum

import com.example.musicassignmentapp.data.model.AlbumX
import com.google.gson.annotations.SerializedName

data class Albummatches(
    @SerializedName("album")
    val album: ArrayList<AlbumX>
)