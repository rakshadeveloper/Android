package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString("message")

            if (msg?.isEmpty()!!) {
                textViewShow.text = "🤪Nothing to Show🤪"
            }
            else
            {
                textViewShow.text = msg.toString()
            }
        }
    }
