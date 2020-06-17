package com.example.musicassignmentapp.data.api

import com.example.musicassignmentapp.data.model.searchalbum.Album
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface ApiService {
    // http://ws.audioscrobbler.com/2.0/
    // ?method=album.search&album=girl&api_key=66e92e75da6e830222b8cd106e954966&format=json

    //https://your.api.com/tasks?sort=value-of-order-parameter
    @GET("2.0/")
    suspend fun getAlbum(@QueryMap options: Map<String, String>): Album

}