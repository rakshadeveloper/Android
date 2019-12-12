package com.example.coachapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() , FragmentScreenOne.OnFragmentScreenOneListener ,
    FragmentScreentwo.OnFragmentScreentoeListener  ,
    FragmentScreenThree.OnFragmentScreenThreeListener , FragmentScreenFour.onFrangmentScreenFourListner {

    private val fragmentManager = supportFragmentManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onGotoOne()

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

    override fun goToTwo() {
        loadFragment(R.id.frameLayout,fragmentManager.beginTransaction() , FragmentScreentwo() , "FragmentScreentoe", false)
    }

    override fun gotoThree() {
        loadFragment(R.id.frameLayout,fragmentManager.beginTransaction() , FragmentScreenThree() , "FragmentScreenThree", false)

    }

    override fun gotoFour() {
        loadFragment(R.id.frameLayout,fragmentManager.beginTransaction() , FragmentScreenFour() , "FragmentScreenFour", false)
    }

    fun onGotoOne() {
        loadFragment(R.id.frameLayout,fragmentManager.beginTransaction() , FragmentScreenOne() , "FragmentScreenThree", false)
    }

    override fun onGotToOne() {
        onGotoOne()
    }


//    fun popUpFragment(fragmentManager : FragmentManager, numberOfFragment : Int) {
//        fragmentManager.popBackStack(
//            fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - numberOfFragment).id,
//            POP_BACK_STACK_INCLUSIVE
//        )
//    }
}
