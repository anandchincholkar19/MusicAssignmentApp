package com.example.musicassignmentapp.data.api

import com.example.musicassignmentapp.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
   // http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=Cher&api_key=66e92e75da6e830222b8cd106e954966&format=json
        private  val BASE_URL = "http://ws.audioscrobbler.com/"

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}