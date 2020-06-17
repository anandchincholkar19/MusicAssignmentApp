package com.example.musicassignmentapp.data.ui.musiclist.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicassignmentapp.data.api.ApiHelperImpl
import com.example.musicassignmentapp.data.api.RetrofitBuilder
import com.example.musicassignmentapp.data.model.searchalbum.Album
import com.example.musicassignmentapp.data.ui.base.ViewModelFactory
import com.example.musicassignmentapp.data.ui.musiclist.adapter.MusicListAdapter
import com.example.musicassignmentapp.data.ui.musiclist.viewmodel.MusicListViewModel
import com.example.musicassignmentapp.utils.MusicAppConstatnt
import com.example.musicassignmentapp.utils.Status
import kotlinx.android.synthetic.main.activity_main.*


class MusicAppLandingActivity : AppCompatActivity(), View.OnClickListener {

    private var serachName: String = MusicAppConstatnt.EMPTY_STRING
    private var serachtype: String = MusicAppConstatnt.EMPTY_STRING
    private lateinit var musicListViewModel: MusicListViewModel
    private lateinit var adapter: MusicListAdapter


    override fun onClick(view: View?) {

        val selectedID = radioType.getCheckedRadioButtonId()
        val radioButton: RadioButton = findViewById(selectedID)
        this.serachtype = radioButton.text.toString() + MusicAppConstatnt.SUFFIX_SEARCH
        this.serachName = edt_name.text.toString()
        setupViewModel()
        musicListViewModel.fetchList()
        setupObserver()
    }
    //http://ws.audioscrobbler.com/2.0/?method=album.getinfo&api_key=66e92e75da6e830222b8cd106e954966&artist=Cher&album=Believe&format=json
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.musicassignmentapp.R.layout.activity_main)
        setupUI()
    }

    private fun setupUI() {
        this.serachName = edt_name.text.toString()
        btn_search.setOnClickListener(this)
        recylerview.layoutManager = LinearLayoutManager(this)
        adapter = MusicListAdapter(arrayListOf())
        recylerview.addItemDecoration(
            DividerItemDecoration(
                recylerview.context,
                (recylerview.layoutManager as LinearLayoutManager).orientation
            )
        )
        recylerview.adapter = adapter
    }

    private fun setupObserver() {
        musicListViewModel.getAlbums().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    recylerview.visibility = View.VISIBLE
                    it.data?.let { searchList ->
                        renderList(searchList)
                    }
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recylerview.visibility = View.GONE
                }
            }
        })
    }

    private fun renderList(album: Album) {
        adapter.addData(album.results.albummatches.album)
        Log.e("MusicAppActivity:", album.results.albummatches.album.toString())
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        val albumQueryParams = HashMap<String, String>()
        albumQueryParams.put(MusicAppConstatnt.ALBUM_KEY, "Girl")
        albumQueryParams.put(MusicAppConstatnt.METHOD_KEY, serachtype)
        albumQueryParams.put(MusicAppConstatnt.API_KEY, MusicAppConstatnt.API_KEY_VALUE)
        albumQueryParams.put(MusicAppConstatnt.FORMAT_KEY, MusicAppConstatnt.FORMAT_VALUE)
        musicListViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelperImpl(RetrofitBuilder().apiService), albumQueryParams)
        ).get(MusicListViewModel::class.java)
    }
}
