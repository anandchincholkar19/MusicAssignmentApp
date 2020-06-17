package com.example.musicassignmentapp.utils

import com.example.musicassignmentapp.data.model.AlbumX

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> Succcess(data: T?): Resource<T>? {
            return Resource(Status.SUCCESS, data, null);
        }

        fun <T> Error(message :String? , data: T? ) : Resource<T> {
            return Resource(Status.ERROR, data, message);
        }

        fun <T> LOADING(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null);
        }
    }
}