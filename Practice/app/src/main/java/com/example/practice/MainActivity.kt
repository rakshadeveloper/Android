package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    val listDummy = arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listDummy)
        btnAdd.setOnClickListener{
            listDummy.set(index = 0, value = "${editText.text}")

        }


    }
}


