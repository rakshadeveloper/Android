package com.example.tourism

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_placedetail.*


class PlaceDetailActivity : AppCompatActivity() {



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
    }

}