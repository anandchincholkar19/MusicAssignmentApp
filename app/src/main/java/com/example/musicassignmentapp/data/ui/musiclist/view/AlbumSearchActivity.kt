package com.example.musicassignmentapp.data.ui.musiclist.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicassignmentapp.R
import com.example.musicassignmentapp.data.api.ApiHelperImpl
import com.example.musicassignmentapp.data.api.RetrofitBuilder
import com.example.musicassignmentapp.data.model.searchalbum.Album
import com.example.musicassignmentapp.data.ui.base.ViewModelFactory
import com.example.musicassignmentapp.data.ui.musiclist.adapter.MusicListAdapter
import com.example.musicassignmentapp.data.ui.musiclist.viewmodel.MusicListViewModel
import com.example.musicassignmentapp.utils.MusicAppConstatnt
import com.example.musicassignmentapp.utils.OnItemClickListener
import com.example.musicassignmentapp.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

class AlbumSearchActivity : AppCompatActivity(), View.OnClickListener, OnItemClickListener {

    override fun onItemClick(artistName: String) {
        val artistInfoActivityIntent = Intent(this@AlbumSearchActivity, ArtistInfoActivity::class.java)
        artistInfoActivityIntent.putExtra(MusicAppConstatnt.ARTIST_KEY, artistName)
        startActivity(artistInfoActivityIntent)
    }

    private var serachName: String = MusicAppConstatnt.EMPTY_STRING
    private lateinit var musicListViewModel: MusicListViewModel
    private lateinit var adapter: MusicListAdapter

    override fun onClick(view: View?) {
        setupViewModel()
        setupObserver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.musicassignmentapp.R.layout.activity_main)
        supportActionBar?.hide()
        setupUI()
    }

    private fun setupUI() {
        this.serachName = edt_name.text.toString()
        btn_search.setOnClickListener(this)
        recylerview.layoutManager = LinearLayoutManager(this)
        adapter = MusicListAdapter(arrayListOf(), this)
        recylerview.adapter = adapter
    }

    private fun setupObserver() {
        musicListViewModel.getAlbums().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    recylerview.visibility = View.VISIBLE
                    txt_error.visibility = View.GONE
                    it.data?.let { searchList ->
                        renderList(searchList)
                    }
                }
                Status.ERROR -> {
                    txt_error.visibility = View.VISIBLE
                    txt_error.text = it.message.toString()
                    progressBar.visibility = View.GONE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recylerview.visibility = View.GONE
                    txt_error.visibility = View.GONE
                }
            }
        })
    }

    private fun renderList(album: Album) {
            if (album.results.albummatches.album.size == 0){
                txt_error.visibility = View.VISIBLE
                txt_error.text = resources.getText(R.string.album_not_find)
            }
            adapter.addData(album.results.albummatches.album)
            adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        val albumQueryParams = HashMap<String, String>()
        albumQueryParams.put(MusicAppConstatnt.ALBUM_KEY, edt_name.text.toString())
        albumQueryParams.put(MusicAppConstatnt.METHOD_KEY, MusicAppConstatnt.ALBUM_VALUE)
        albumQueryParams.put(MusicAppConstatnt.API_KEY, MusicAppConstatnt.API_KEY_VALUE)
        albumQueryParams.put(MusicAppConstatnt.FORMAT_KEY, MusicAppConstatnt.FORMAT_VALUE)
        musicListViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelperImpl(RetrofitBuilder().apiService))
        ).get(MusicListViewModel::class.java)

        musicListViewModel.fetchList(albumQueryParams)
    }
}
