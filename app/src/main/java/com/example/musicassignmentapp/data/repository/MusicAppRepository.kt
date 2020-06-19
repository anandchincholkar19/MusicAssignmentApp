package com.example.musicassignmentapp.data.repository

import com.example.musicassignmentapp.data.model.infoartist.Artistinfo
import com.example.musicassignmentapp.data.model.searchalbum.Album

interface MusicAppRepository {

    suspend fun getAlbums(mapParams: HashMap<String, String>): Album
    suspend fun getArtristInfo(mapParams: HashMap<String, String>): Artistinfo
}