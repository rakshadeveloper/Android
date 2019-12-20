package com.example.tourism

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var tourPlaceDetail = "Lucknow, a large city in northern India, is the capital of the state of Uttar Pradesh. Toward its center is Rumi Darwaza, a Mughal gateway. Nearby, the 18th-century Bara Imambara shrine has a huge arched hall. Upstairs, Bhool Bhulaiya is a maze of narrow tunnels with city views from its upper balconies. Close by, the grand Victorian Husainabad Clock Tower was built as a victory column in 1881. Lucknow has a humid subtropical climate with cool, dry winters from mid-November to February and dry, hot summers with thunderstorms from late March to June. The rainy season is from July to September when the city gets an average rainfall of 896.2 millimetres (35.28 in) from the south-west monsoon winds, and occasionally frontal rainfall will occur in January. In winter the maximum temperature is around 25 °C (77 °F) and the minimum is in the 3 °C (37 °F) to 7 °C (45 °F) range."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvAboutPlace.setMovementMethod(ScrollingMovementMethod())
        tvPlaceName.text = "Lucknow"
        tvAboutPlace.text ="$tourPlaceDetail"

        btnVisiteOptions.setOnClickListener {
            val intent = Intent(this, VisiteOptionsActivity::class.java)
            startActivity(intent)
        }
    }
}


