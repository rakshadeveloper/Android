package com.example.batterystatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        this.registerReceiver(myBroadcastReceiver,intentFilter)
        }
    private val myBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            val stringBuilder = StringBuilder()
//            val batteryPercentage = intent.getIntExtra(BatteryManager.EXTRA_LEVEL)
//            val batteryLevel = intent.getIntExtra(BatteryManager, String() : Int)
            val bat : Int = BatteryManager.EXTRA_STATUS.toInt()
            battery_level.text = bat.toString()
        }

    }

    }


