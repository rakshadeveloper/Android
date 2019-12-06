package com.example.coachapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener {

    var spinner: Spinner? = null
    var userID = etUserID
    var userPIN = etPIN
    var languages = arrayOf("English", "French", "Spanish", "Hindi", "Russian","Spanish", "Hindi", "Russian","English", "French", "Spanish", "Hindi", "Russian","Spanish", "Hindi", "Russian")
    val logins = arrayOf("11","12","13","14","15")
    val loginsName = arrayOf("harry","Coal","Jhon","Stephen","Alexander")
    val loginPIN = arrayOf("11","12","13","14","15")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ibtnOptions.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnLoginUser.setOnClickListener {

//            if (userID == logins && userPIN == loginPIN ) {
//                val intent = Intent(this, MainActivity::class.java)
//                intent.putExtra("$loginsName", loginsName)
//                startActivity(intent)
//            }
            val intent = Intent(this, UserDetailActivity::class.java)
            startActivity(intent)
        }

        spinner = this.spnrCrrrier
        spinner!!.setOnItemSelectedListener(this)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(aa)

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
                progressBarOnLogin.incrementProgressBy(percentage)
            }
            if (isCharging) {

            } else {
                ivChargingStausOnLogin.setVisibility(View.GONE)
            }

        }
    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }
}



