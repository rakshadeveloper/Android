package com.example.tourism.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.tourism.R

class ImageSliderAdapter : PagerAdapter {


    lateinit var context : Context
    lateinit var slidingImage:Array<Int>

    lateinit var inflater: LayoutInflater

        constructor(context: Context , slidingImage:Array<Int>):super() {

            this.context = context
            this.slidingImage = slidingImage

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view== `object` as RelativeLayout

    override fun getCount(): Int = slidingImage.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var images : ImageView
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view : View = inflater.inflate(R.layout.slidingimage_layout, container , false)
        images = view.findViewById(R.id.ivMultiImage)
        images.setBackgroundResource(slidingImage[position])
        container!!.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container!!.removeView(`object` as RelativeLayout)
    }



}