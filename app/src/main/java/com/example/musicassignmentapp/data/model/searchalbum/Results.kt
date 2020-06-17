package com.example.musicassignmentapp.data.model.searchalbum


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("albummatches")
    val albummatches: Albummatches,
    @SerializedName("opensearch:itemsPerPage")
    val opensearchItemsPerPage: String,
    @SerializedName("opensearch:startIndex")
    val opensearchStartIndex: String,
    @SerializedName("opensearch:totalResults")
    val opensearchTotalResults: String
)