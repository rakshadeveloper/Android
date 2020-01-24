package com.example.tourism.adapter

import android.content.Context
import android.provider.ContactsContract
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tourism.DetailList
import com.example.tourism.R
import com.example.tourism.RecyclerItemClickListener
import com.example.tourism.model.Places

class CustomAdapterList(
    private val dataList : MutableList<Places>,
    var list: ArrayList<DetailList>,
    val listener: RecyclerItemClickListener
) : RecyclerView.Adapter<CustomAdapterList.ViewHolder>(){

    class ViewHolder (iteamView : View) : RecyclerView.ViewHolder(iteamView)  {

        val ivPlaces = iteamView.findViewById(R.id.ivPlaces) as ImageView
        val tvSubPlaceNames = iteamView.findViewById(R.id.tvSubPlaceNames) as TextView
        val tvSubPlaceDetail = iteamView.findViewById(R.id.tvSubPlaceDetail) as TextView

    }
    private lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val v = LayoutInflater.from(context).inflate(R.layout.list_places, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
//        return list.size
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place : DetailList = list[position]
        val data = dataList[position]
        val placeJSON = "${data.place}"
//        holder.tvSubPlaceNames.text = place.subPlaceName
        holder.tvSubPlaceNames.text = placeJSON
        holder.tvSubPlaceDetail.text = place.subPlaceDetail
        holder.ivPlaces.setImageResource(place.subPlaceImage)
        holder.tvSubPlaceDetail.setMovementMethod(ScrollingMovementMethod())

        holder.itemView.setOnClickListener { if (listener != null) {
            listener.OnItemClick(position)
        }}


    }
}

