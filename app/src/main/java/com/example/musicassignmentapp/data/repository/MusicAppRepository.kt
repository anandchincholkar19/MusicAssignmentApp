package com.example.musicassignmentapp.data.repository

import com.example.musicassignmentapp.data.model.searchalbum.Album

interface MusicAppRepository {

    suspend fun getAlbums(mapParams: HashMap<String, String>): Album

//    suspend fun getAlbumInfo():List<News>
//
//    suspend fun getArtist():List<News>
//    suspend fun getArtristInfo():List<News>
}