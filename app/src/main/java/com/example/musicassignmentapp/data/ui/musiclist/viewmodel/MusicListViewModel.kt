package com.example.musicassignmentapp.data.ui.musiclist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicassignmentapp.data.model.searchalbum.Album
import com.example.musicassignmentapp.data.repository.MusicAppRepository
import com.example.musicassignmentapp.utils.Resource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MusicListViewModel(
    private val newsListRepository: MusicAppRepository
) : ViewModel() {

    private val list = MutableLiveData<Resource<Album>>()

    public fun fetchList(queryParams: HashMap<String, String>) {
        CoroutineExceptionHandler { _, exceptio ->
        }
        viewModelScope.launch {
            list.postValue(Resource.LOADING(null))
            try {
                val response = newsListRepository.getAlbums(queryParams)
                list.postValue(Resource.Succcess(response))
            } catch (e: Exception) {
                list.postValue(Resource.Error(e.message, null))
            }
        }
    }

    fun getAlbums(): LiveData<Resource<Album>> {
        return list
    }
}