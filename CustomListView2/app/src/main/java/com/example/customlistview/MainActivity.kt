package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.textView)
        val list = mutableListOf<Hero>()

        list.add(Hero(R.drawable.andwomen, "antwomen"))
        list.add(Hero(R.drawable.captainamerica, "captainamerica"))
        list.add(Hero(R.drawable.captainmarvel, "captainmarvel"))
        list.add(Hero(R.drawable.hulk, "hulk"))
        list.add(Hero(R.drawable.ironman, "ironman"))
        list.add(Hero(R.drawable.natasha, "natasha"))
        list.add(Hero(R.drawable.petter, "petter"))
        list.add(Hero(R.drawable.woderwomen, "woderwomen"))

        val adapter = MyAdapter(this, R.layout.my_list_item, list)
        listView.adapter = adapter
    }
}
