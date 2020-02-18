package com.example.youtubersapp.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.youtubersapp.R
import kotlinx.android.synthetic.main.second_screen.*
import java.util.*

class SecondScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)
        btnEnglish.setOnClickListener {
            val locale = Locale("en")
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics())
            val intent = Intent(this, ThirdScreen::class.java)
            startActivity(intent)
            finish()
        }

        btnHindi.setOnClickListener {
            val locale = Locale("hi_IN")
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics())
            val intent = Intent(this, ThirdScreen::class.java)
            startActivity(intent)
            finish()
        }
    }

}