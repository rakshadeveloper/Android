package com.example.youtubersapp.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.youtubersapp.R
import com.example.youtubersapp.adapter.MyAdapter
import com.example.youtubersapp.tabfragments.FavoritesFragment
import com.example.youtubersapp.tabfragments.MovieFragment
import com.example.youtubersapp.tabfragments.NotificationFragment
import com.example.youtubersapp.tabfragments.PlayListFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.third_screem.*

class ThirdScreen : AppCompatActivity(), MovieFragment.OnFragmentInteractionListener, PlayListFragment.OnFragmentInteractionListener , NotificationFragment.OnFragmentInteractionListener , FavoritesFragment.OnFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_screem)

        ivOptionButton.setOnClickListener {
            val i = Intent(this, FourthOptionScreen::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.slide_in_left , R.anim.slide_out_right)
        }
        ivSearchButton.setOnClickListener {
            val i = Intent(this, FiveSearchScreen::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left)
        }

    var tabLayout = findViewById<TabLayout>(R.id.tabLayout)
    var viewPager = findViewById<ViewPager>(R.id.viewPager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Video"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Playlist"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Notification"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Favorites"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_CENTER

        val adapter = MyAdapter(this, supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}