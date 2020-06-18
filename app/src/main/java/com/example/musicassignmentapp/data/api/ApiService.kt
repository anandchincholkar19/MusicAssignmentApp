package com.example.musicassignmentapp.data.api

import com.example.musicassignmentapp.data.model.infoartist.Artist
import com.example.musicassignmentapp.data.model.infoartist.Artistinfo
import com.example.musicassignmentapp.data.model.searchalbum.Album
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET("2.0/")
    suspend fun getAlbum(@QueryMap options: Map<String, String>): Album

    @GET("2.0/")
    suspend fun getArtistInfo(@QueryMap options: Map<String, String>): Artistinfo

}