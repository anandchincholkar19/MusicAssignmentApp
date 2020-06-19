package com.example.musicassignmentapp.data.ui.musiclist.view

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.musicassignmentapp.R
import com.example.musicassignmentapp.data.api.ApiHelperImpl
import com.example.musicassignmentapp.data.api.RetrofitBuilder
import com.example.musicassignmentapp.data.model.infoartist.Artistinfo
import com.example.musicassignmentapp.data.ui.base.ViewModelFactory
import com.example.musicassignmentapp.data.ui.musiclist.viewmodel.ArtistInfoViewModel
import com.example.musicassignmentapp.utils.MusicAppConstatnt
import com.example.musicassignmentapp.utils.Status
import kotlinx.android.synthetic.main.activity_artist_info.*

class ArtistInfoActivity : AppCompatActivity() {

    private lateinit var artistInfoViewModel: ArtistInfoViewModel
    private var artistName: String = MusicAppConstatnt.EMPTY_STRING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_info)
        supportActionBar?.hide()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI(artistinfo: Artistinfo) {
        txt_artist_name.text = artistinfo.artist.name
        txt_artist_url.text = artistinfo.artist.url
        txt_summery.text = Html.fromHtml(artistinfo.artist.bio.summary)
        txt_more_info_url.text = Html.fromHtml(artistinfo.artist.bio.links.link.href)
    }

    private fun setupObserver() {
        artistInfoViewModel.getArtistInfo().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { artistinfo ->
                        setupUI(artistinfo)
                    }
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setupViewModel() {

        intent?.let {
            artistName = it.getStringExtra(MusicAppConstatnt.ARTIST_KEY)
        }
        val artistQueryParams = HashMap<String, String>()
        artistQueryParams.put(MusicAppConstatnt.METHOD_KEY, MusicAppConstatnt.ARTIST_METHOD_VALUE)
        artistQueryParams.put(MusicAppConstatnt.ARTIST_KEY, artistName)
        artistQueryParams.put(MusicAppConstatnt.API_KEY, MusicAppConstatnt.API_KEY_VALUE)
        artistQueryParams.put(MusicAppConstatnt.FORMAT_KEY, MusicAppConstatnt.FORMAT_VALUE)
        artistInfoViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelperImpl(RetrofitBuilder().apiService))
        ).get(ArtistInfoViewModel::class.java)

        artistInfoViewModel.fetchArtistInfo(artistQueryParams)
    }

}
