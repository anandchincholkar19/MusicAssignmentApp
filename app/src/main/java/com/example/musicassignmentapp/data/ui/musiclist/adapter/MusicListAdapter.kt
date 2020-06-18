package com.example.musicassignmentapp.data.ui.musiclist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicassignmentapp.R
import com.example.musicassignmentapp.data.model.AlbumX
import com.example.musicassignmentapp.utils.OnItemClickListener
import kotlinx.android.synthetic.main.item_layout.view.*

class MusicListAdapter(private val albumList: ArrayList<AlbumX> ,
                       private val listener: OnItemClickListener):
    RecyclerView.Adapter<MusicListAdapter.DataViewHolder>() {

    override fun onBindViewHolder(holder:DataViewHolder, position :Int){
        holder.bind(albumList.get(position))
        holder.itemView.setOnClickListener {
            listener.onItemClick(albumList.get(position).name)
        }
    }

    override fun getItemCount(): Int {
      return albumList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder{
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        )
    }

    class DataViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(album: AlbumX){
            itemView.txt_view_name.text = album.name
            itemView.txt_view_desc.text = album.artist
        }
    }

    fun addData(list:ArrayList<AlbumX>){
        albumList.clear()
        albumList.addAll(list)
    }


}