package com.example.musicassignmentapp.data.model.searchalbum


import com.example.musicassignmentapp.data.model.searchalbum.Results
import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("results")
    val results: Results
)