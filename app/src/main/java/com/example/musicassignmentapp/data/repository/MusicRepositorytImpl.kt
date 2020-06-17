package com.example.musicassignmentapp.data.repository

import com.example.musicassignmentapp.data.api.ApiHelper
import com.example.musicassignmentapp.data.model.searchalbum.Album

class MusicRepositorytImpl(private val apiHelper: ApiHelper) : MusicAppRepository {

    override suspend fun getAlbums(mapParams: HashMap<String, String>): Album {
        return apiHelper.getAlbum(mapParams)
    }

    //   override suspend fun getNews(): List<News> =  apiHelper.getNews()

    //   override suspend fun getMoreNews() =   apiHelper.getMoreNews()

}