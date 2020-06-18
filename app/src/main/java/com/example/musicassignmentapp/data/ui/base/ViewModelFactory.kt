package com.example.musicassignmentapp.data.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicassignmentapp.data.api.ApiHelper
import com.example.musicassignmentapp.data.repository.MusicRepositorytImpl
import com.example.musicassignmentapp.data.ui.musiclist.viewmodel.ArtistInfoViewModel
import com.example.musicassignmentapp.data.ui.musiclist.viewmodel.MusicListViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MusicListViewModel::class.java)) {
            return MusicListViewModel(MusicRepositorytImpl(apiHelper)) as T
        }
        if (modelClass.isAssignableFrom(ArtistInfoViewModel::class.java)) {
            return ArtistInfoViewModel(MusicRepositorytImpl(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}