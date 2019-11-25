package com.example.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var mCtx: Context, var resource: Int, var items: List<Hero>)
    : ArrayAdapter<Hero>(mCtx, resource, items)

{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resource, null)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textView: TextView = view.findViewById(R.id.textView)
        val hero:Hero = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(hero.image))
        textView.text = hero.name
        return view
    }
}