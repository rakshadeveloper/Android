package com.example.coachapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_deviceinformation.*


class DeviceInformationActivity: AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deviceinformation)
        ibtnBackDeviceInfo.setOnClickListener {
            finish()
        }
        getHardwareAndSoftwareInfo()

        var intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        this.registerReceiver(myBroadcastReceiver,intentFilter)
    }

    private val myBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            val batteryStatus: Intent? =
                IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
                    context?.registerReceiver(null, ifilter)
                }
            val status: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
            val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING
                    || status == BatteryManager.BATTERY_STATUS_FULL

            val chargePlug: Int =
                batteryStatus?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) ?: -1
            val usbCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
            val acCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_AC

            val batteryPct: Float? = batteryStatus?.let { intent ->
                val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                level / scale.toFloat()
            }
            val percentage: Int = batteryPct?.times(100)!!.toInt()
            if (percentage != null) {
                percentage.toInt()
                progressBarDeviceInfo.incrementProgressBy(percentage)
            }
            if (isCharging) {

            } else {
                ivChargingStausDeviceInfo.setVisibility(View.GONE)
            }
            tvPowerStatus.text = "$percentage% "

        }
    }

    fun getHardwareAndSoftwareInfo() {
        tvModelNumber.text = "${Build.MODEL}"
        tvSerialNumber.text = "${Build.BRAND}"
        tvHardwareVersion.text = "${Build.HARDWARE}"
        tvCellularCarrier.text = "$"
        tvAPPVersion.text = "$"
//        tvIMEINumber.text = "${Build.get}"
//        android.telephony.TelephonyManager
    }
}