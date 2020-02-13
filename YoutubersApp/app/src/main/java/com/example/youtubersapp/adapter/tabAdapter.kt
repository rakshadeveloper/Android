package com.example.youtubersapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.youtubersapp.tabfragments.FavoritesFragment
import com.example.youtubersapp.tabfragments.MovieFragment
import com.example.youtubersapp.tabfragments.NotificationFragment
import com.example.youtubersapp.tabfragments.PlayListFragment

class MyAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return MovieFragment()
            }
            1 -> {
                return PlayListFragment()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                return NotificationFragment()
            }
            3 -> {
                // val movieFragment = MovieFragment()
                return FavoritesFragment()
            }
            else -> return  checkNotNull(Fragment())
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}