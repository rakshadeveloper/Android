package com.example.tourism


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapterGrid(
    var list: ArrayList<DetailList>,
    val listener: RecyclerItemClickListener
) : RecyclerView.Adapter<CustomAdapterGrid.ViewHolder>(){

    class ViewHolder (iteamView : View) : RecyclerView.ViewHolder(iteamView)  {

        val ivPlaceImageGrid = iteamView.findViewById(R.id.ivPlaceImageGrid) as ImageView
        val tvTitleGrid = iteamView.findViewById(R.id.tvTitleGrid) as TextView
//        val tvSubPlaceDetail = iteamView.findViewById(R.id.tvSubPlaceDetail) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.grid_places, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place :DetailList  = list[position]

        holder.tvTitleGrid.text = place.subPlaceName
//        holder.tvSubPlaceDetail.text = place.subPlaceDetail
        holder.ivPlaceImageGrid.setImageResource(place.subPlaceImage)
//        holder.tvSubPlaceDetail.setMovementMethod(ScrollingMovementMethod())

        holder.itemView.setOnClickListener { if (listener != null) {
            listener.OnItemClick(position)
        }}


    }
}

