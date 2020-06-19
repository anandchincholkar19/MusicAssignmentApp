package com.example.musicassignmentapp.data.api

import com.example.musicassignmentapp.data.model.infoartist.Artistinfo
import com.example.musicassignmentapp.data.model.searchalbum.Album

class ApiHelperImpl (private val apiService: ApiService): ApiHelper {
    override suspend fun getArtistInfo(queryParams: Map<String,String>): Artistinfo {
        return apiService.getArtistInfo(queryParams)
    }

    override suspend fun getAlbum(queryParams: Map<String,String>): Album {
        return apiService.getAlbum(queryParams)
    }




}