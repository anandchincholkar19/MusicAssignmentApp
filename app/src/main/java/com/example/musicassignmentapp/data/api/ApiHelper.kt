package com.example.musicassignmentapp.data.api

import com.example.musicassignmentapp.data.model.AlbumX
import com.example.musicassignmentapp.data.model.searchalbum.Album
import com.example.musicassignmentapp.data.model.searchalbum.Albummatches

interface ApiHelper {

    suspend fun getAlbum(queryParams: Map<String,String>): Album
//    suspend fun getAlbumInfo():List<News>
//    suspend fun getArtist():List<News>
//    suspend fun getArtistInfo():List<News>
}