package com.example.youtubersapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.youtubersapp.R
import kotlinx.android.synthetic.main.fourth_option_screen.*

class FourthOptionScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fourth_option_screen)

        ivCloseOptin.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left)
        }
    }
}