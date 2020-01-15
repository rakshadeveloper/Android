package com.example.tourism

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.tourism.adapter.ImageSliderAdapter
import kotlinx.android.synthetic.main.activity_placedetail.*


class PlaceDetailActivity : AppCompatActivity() {

    var img :Array<Int> = arrayOf(R.drawable.benz2 , R.drawable.bikess , R.drawable.harley2 , R.drawable.img1 , R.drawable.vecto , R.drawable.webshots)
    var adapter : PagerAdapter = ImageSliderAdapter(
        context = application,
        slidingImage = img
    )
    val pagerView = findViewById(R.id.pager) as ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placedetail)

        val image = findViewById(R.id.ivImage) as ImageView

        val bundle: Bundle? = intent.extras
        val place_name: String? = intent.getStringExtra("placename")
        val place_name_detail: String? = intent.getStringExtra("placeDetail")
        val place_image = intent.getIntExtra("image",R.drawable.gomti_riverfront_park)

        tvTitle.text = place_name
        tvTitleDetail.text = place_name_detail
        image.setImageResource(place_image)
        pagerView.adapter = adapter
    }

}