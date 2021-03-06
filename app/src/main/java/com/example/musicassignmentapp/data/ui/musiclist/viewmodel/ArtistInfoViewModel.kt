package com.example.musicassignmentapp.data.ui.musiclist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicassignmentapp.data.model.infoartist.Artistinfo
import com.example.musicassignmentapp.data.repository.MusicAppRepository
import com.example.musicassignmentapp.utils.Resource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class ArtistInfoViewModel(
    private val musicListRepository: MusicAppRepository
) : ViewModel() {

    private val artistInfo = MutableLiveData<Resource<Artistinfo>>()

     fun fetchArtistInfo(queryParams:HashMap<String,String>) {
        CoroutineExceptionHandler { _, exceptio ->
        }
        viewModelScope.launch {
            artistInfo.postValue(Resource.LOADING(null))
            try {
                val response = musicListRepository.getArtristInfo(queryParams)
                artistInfo.postValue(Resource.Succcess(response))
            } catch (e: Exception) {
                artistInfo.postValue(Resource.Error(e.message, null))
            }
        }
    }

    fun getArtistInfo(): LiveData<Resource<Artistinfo>> {
        return artistInfo
    }
}