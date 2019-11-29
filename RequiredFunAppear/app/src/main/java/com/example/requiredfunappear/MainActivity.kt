package com.example.requiredfunappear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn1
import kotlinx.android.synthetic.main.activity_main.btn2
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {

    var clicked1: Boolean = false
    var clicked2: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
//            btButton.visibility = View.INVISIBLE
            clicked1 = true
            }
        btn2.setOnClickListener {
//            button2.visibility = View.GONE
            clicked2 = true
        }
        nextActivity.setOnClickListener {

            if (clicked1 == true || clicked2 == true) {
                setContentView(R.layout.activity_second)
                if (clicked1 == true) {
                    btButton.visibility = View.GONE
                }
                if (clicked2 == true) {
                    button2.visibility = View.GONE
                }
            }
            else {
                setContentView(R.layout.activity_second)
            }
        }
    }
}