package com.example.coachapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.*
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , FragmentScreenOne.OnFragmentScreenOneListener ,
    FragmentScreentoe.OnFragmentScreentoeListener , FragmentScreenThree.OnFragmentScreenThreeListener {

    private val fragmentManager = supportFragmentManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        getSupportActionBar()!!.hide()

        onLoginPressed()





//        var intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
//        this.registerReceiver(myBroadcastReceiver,intentFilter)
    }

    fun loadFragment(layout : Int, fragmentTransaction : FragmentTransaction, fragment : Fragment, tag : String, addToBackStack : Boolean) {
        val fragmentObject = fragment
        fragmentTransaction.replace(layout, fragmentObject, tag)
        if(addToBackStack){
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }

    override fun onLoginPressed() {
        loadFragment(R.id.frameLayout,fragmentManager.beginTransaction() , FragmentScreentoe() , "FragmentScreentoe", false)

    }

    override fun onGotoOtherPressed() {
        loadFragment(R.id.frameLayout,fragmentManager.beginTransaction() , FragmentScreenOne() , "FragmentScreenOne", false)
    }

    override fun onGotoThreePressed() {
        loadFragment(R.id.frameLayout,fragmentManager.beginTransaction() , FragmentScreenThree() , "FragmentScreenThree", false)
    }


//    fun popUpFragment(fragmentManager : FragmentManager, numberOfFragment : Int) {
//        fragmentManager.popBackStack(
//            fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - numberOfFragment).id,
//            POP_BACK_STACK_INCLUSIVE
//        )
//    }




//    private val myBroadcastReceiver = object : BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent?) {
//
//            val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
//                context?.registerReceiver(null, ifilter)
//            }
//            val status: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
//            val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING
//                    || status == BatteryManager.BATTERY_STATUS_FULL
//
//            val chargePlug: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) ?: -1
//            val usbCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
//            val acCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_AC
//
//            val batteryPct: Float? = batteryStatus?.let { intent ->
//                val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
//                val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
//                level / scale.toFloat()
//            }
//            val percenage: Int = batteryPct?.times(100)!!.toInt()
//            if (percenage != null) {
//                percenage.toInt()
//                progressBar.incrementProgressBy(percenage)
//            }
//            if ( isCharging ) {
//
//            }
//            else {
//                ivChargingStaus.setVisibility(View.GONE)
//            }
//        }
//
//    }
}
