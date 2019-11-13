package com.example.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNextActivity.setOnClickListener{

            //editText.text = "Welcome, In the World of Kotlin"
            val message: String = editText.text.toString()
            //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message", message)
            startActivity(intent)
        }

        btnShareTo.setOnClickListener{
            val message: String = editText.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "To Share::"))

        }
        btnRecyclerView.setOnClickListener{
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}
