package com.example.musicassignmentapp.data.api

import com.example.musicassignmentapp.data.model.infoartist.Artistinfo
import com.example.musicassignmentapp.data.model.searchalbum.Album

interface ApiHelper {

    suspend fun getAlbum(queryParams: Map<String,String>): Album
    suspend fun getArtistInfo(queryParams: Map<String,String>): Artistinfo

}