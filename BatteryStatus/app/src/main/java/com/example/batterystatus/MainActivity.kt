package com.example.batterystatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        this.registerReceiver(myBroadcastReceiver,intentFilter)

        val imageView = ImageView(this)
//        imageView.setImageResource

        }
    private val myBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
                context?.registerReceiver(null, ifilter)
            }
            val status: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
            val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING
                    || status == BatteryManager.BATTERY_STATUS_FULL

            val chargePlug: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) ?: -1
            val usbCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
            val acCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_AC

            val batteryPct: Float? = batteryStatus?.let { intent ->
                val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                level / scale.toFloat()
            }
            val percenage: Int = batteryPct?.times(100)!!.toInt()
            if (percenage != null) {
                percenage.toInt()
                battery_level.text = "$percenage %"
            }

            if ( isCharging ) {
                battery_ChargingStatus.text = "Charging"
            }
            else if(percenage == 100) {
                battery_ChargingStatus.text = "Battery Full"
            }
            else {
                battery_ChargingStatus.text = "Not Charging"
            }
        }

    }

    }


