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
    lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent();
    }

    private fun setContent() {
        setContentView(R.layout.activity_main)

        mainActivity = this

        btn1.setOnClickListener {
            //            btButton.visibility = View.INVISIBLE
            clicked1 = true
        }
        btn2.setOnClickListener {
            //            button2.visibility = View.GONE
            clicked2 = true
        }
        nextActivity.setOnClickListener {
            var intent = Intent(mainActivity, SecondActivity::class.java)
            intent.putExtra("clicked1", clicked1)
            intent.putExtra("clicked2", clicked2)
            startActivity(intent)
            clicked1 = false
            clicked2 = false
        }
    }
}