package com.adityaa0108.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewParent

import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

        lateinit var tabLayout: TabLayout


       lateinit var toolbar: Toolbar
       lateinit var viewPager: ViewPager
       lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
           toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
         val home = findViewById<TabItem>(R.id.home)


        val science= findViewById<TabItem>(R.id.science)
        val  health= findViewById<TabItem>(R.id.health)
         val tech= findViewById<TabItem>(R.id.technology)
        val entertainment= findViewById<TabItem>(R.id.entertainment)
        val sports= findViewById<TabItem>(R.id.sports)
            viewPager = findViewById(R.id.fragmentContainer)
        tabLayout = findViewById(R.id.include)
         pagerAdapter = PagerAdapter(supportFragmentManager,6)
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout)) //code to swap the tabs
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener { //code to click on the tab
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                if(tab.position == 0 || tab.position == 1 || tab.position == 2 || tab.position == 3 || tab.position == 4 || tab.position == 5 ){
                    pagerAdapter.notifyDataSetChanged()

                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


    }
}