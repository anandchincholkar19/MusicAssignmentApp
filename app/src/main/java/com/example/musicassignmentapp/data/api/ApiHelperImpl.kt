package com.example.musicassignmentapp.data.api
import com.example.musicassignmentapp.data.model.AlbumX
import com.example.musicassignmentapp.data.model.searchalbum.Album
import com.example.musicassignmentapp.data.model.searchalbum.Albummatches

class ApiHelperImpl (private val apiService: ApiService): ApiHelper {

    override suspend fun getAlbum(queryParams: Map<String,String>): Album {
        return apiService.getAlbum(queryParams)
    }

//    override suspend fun getAlbumInfo(): List<News> {
//        return null
//    }
//
//    override suspend fun getArtist(): List<News> {
//    }
//
//    override suspend fun getArtistInfo(): List<News> {
//    }


}