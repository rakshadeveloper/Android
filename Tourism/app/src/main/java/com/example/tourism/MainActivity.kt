package com.example.tourism

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvAboutPlace.setMovementMethod(ScrollingMovementMethod())
        tvAboutPlace.setMovementMethod(ScrollingMovementMethod())
    }
}
