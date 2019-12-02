package com.example.requiredfunappear

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity() {


//    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var clicked1 = intent.getBooleanExtra("clicked1", false)
        var clicked2 = intent.getBooleanExtra("clicked2", false)
        if (clicked1 == true) {
            btButton.visibility = View.GONE
        }
        if (clicked2 == true) {
            button2.visibility = View.GONE
        }
    }

}