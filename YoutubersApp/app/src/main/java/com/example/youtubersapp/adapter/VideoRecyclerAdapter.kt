package com.example.youtubersapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubersapp.R
import com.example.youtubersapp.model.AllVideos
import kotlinx.android.extensions.LayoutContainer

class VideoRecyclerAdapter : RecyclerView.Adapter<VideoRecyclerAdapter.ViewHolder>() {
    private var items = listOf<AllVideos>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_video, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]


    }

    fun replaceItems(items: List<AllVideos>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer
}