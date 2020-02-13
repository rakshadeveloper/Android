package com.example.youtubersapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.youtubersapp.R
import kotlinx.android.synthetic.main.second_screen.*

class SecondScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)
        btnEnglish.setOnClickListener {
            val intent = Intent(this, ThirdScreen::class.java)
            startActivity(intent)
        }
    }

}