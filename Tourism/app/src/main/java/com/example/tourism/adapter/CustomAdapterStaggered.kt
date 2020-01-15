package com.example.tourism.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tourism.DetailList
import com.example.tourism.R
import com.example.tourism.RecyclerItemClickListener

class CustomAdapterStaggered (
    var list: ArrayList<DetailList>,
    val listener: RecyclerItemClickListener
): RecyclerView.Adapter<CustomAdapterStaggered.ViewHolder>() {

    class ViewHolder (iteamView : View) : RecyclerView.ViewHolder(iteamView)  {

        val ivPlaceImageStaggered = iteamView.findViewById(R.id.ivPlaceImageStaggered) as ImageView
        val tvTitleStaggered = iteamView.findViewById(R.id.tvTitleStaggered) as TextView
//        val tvSubPlaceDetail = iteamView.findViewById(R.id.tvSubPlaceDetail) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.staggered_places, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place : DetailList = list[position]

        holder.tvTitleStaggered.text = place.subPlaceName
//        holder.tvSubPlaceDetail.text = place.subPlaceDetail
        holder.ivPlaceImageStaggered.setImageResource(place.subPlaceImage)
//        holder.tvSubPlaceDetail.setMovementMethod(ScrollingMovementMethod())

        holder.itemView.setOnClickListener { if (listener != null) {
            listener.OnItemClick(position)
        }}


    }
}