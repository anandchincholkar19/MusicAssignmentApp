package com.example.musicassignmentapp.data.api

import com.example.musicassignmentapp.data.model.AlbumX
import com.example.musicassignmentapp.data.model.infoartist.Artist
import com.example.musicassignmentapp.data.model.infoartist.Artistinfo
import com.example.musicassignmentapp.data.model.searchalbum.Album
import com.example.musicassignmentapp.data.model.searchalbum.Albummatches

interface ApiHelper {

    suspend fun getAlbum(queryParams: Map<String,String>): Album
    suspend fun getArtistInfo(queryParams: Map<String,String>): Artistinfo

}