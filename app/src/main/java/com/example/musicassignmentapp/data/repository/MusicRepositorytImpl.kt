package com.example.musicassignmentapp.data.repository

import com.example.musicassignmentapp.data.api.ApiHelper
import com.example.musicassignmentapp.data.model.infoartist.Artist
import com.example.musicassignmentapp.data.model.infoartist.Artistinfo
import com.example.musicassignmentapp.data.model.searchalbum.Album

class MusicRepositorytImpl(private val apiHelper: ApiHelper) : MusicAppRepository {
    override suspend fun getArtristInfo(mapParams: HashMap<String, String>): Artistinfo {
        return apiHelper.getArtistInfo(mapParams)
    }

    override suspend fun getAlbums(mapParams: HashMap<String, String>): Album {
        return apiHelper.getAlbum(mapParams)
    }

}