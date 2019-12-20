package com.example.tourism

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (Val detailList: ArrayList<DetailList>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    class ViewHolder (iteamView : View) : RecyclerView.ViewHolder(iteamView) {

        val ivPlaces = iteamView.findViewById(R.id.ivPlaces) as ImageView
        val tvSubPlaceNames = iteamView.findViewById(R.id.tvSubPlaceNames) as TextView
        val tvSubPlaceDetail = iteamView.findViewById(R.id.tvSubPlaceDetail) as TextView

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_places, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return detailList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place  = detailList[position]

        holder.ivPlaces = place.image

    }
}

