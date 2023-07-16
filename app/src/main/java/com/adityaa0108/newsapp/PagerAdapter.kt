package com.adityaa0108.newsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter : FragmentPagerAdapter {

        var tabcount:Int
    constructor(fm: FragmentManager, behavior: Int) : super(fm, behavior){
        tabcount = behavior
    }


    override fun getCount(): Int {
              return tabcount
    }

    override fun getItem(position: Int): Fragment {
       when(position){
               0 -> return HomeFragment()
               1 -> return SportsFragment()
               2 -> return HealthFragment()
               3 -> return ScienceFragment()
               4 -> return EntertainmentFragment()
               else -> return TechFragment()


       }

    }

}