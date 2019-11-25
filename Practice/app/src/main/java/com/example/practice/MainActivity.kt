package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    internal lateinit var editText: EditText
    internal lateinit var addButton: Button
    internal lateinit var listItems:ArrayList<String>
    internal lateinit var adapter:ArrayAdapter<String>
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText) as EditText
        addButton = findViewById(R.id.btnAdd) as Button
        listView = findViewById(R.id.listView) as ListView
        listItems = ArrayList<String>()
        adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, listItems)
        listView.setAdapter(adapter)
        addButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v:View) {
                if (TextUtils.isEmpty(editText.text.toString())){ }
                else {
                    listItems.add(editText.getText().toString())
                    
                    adapter.notifyDataSetChanged()
                    editText.text.clear()
                }
            }
        })
        listView.setOnItemClickListener(object: AdapterView.OnItemClickListener {
            override fun onItemClick(a:AdapterView<*>, v:View, position:Int,
                                     id:Long) {
                Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}

