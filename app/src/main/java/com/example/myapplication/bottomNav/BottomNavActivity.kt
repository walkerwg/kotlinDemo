package com.example.myapplication.bottomNav

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavActivity : AppCompatActivity() {


    var fragmentList =
        listOf(HomeFragment(), TestFragment("TestFragment1"), TestFragment("TestFragment2"),TestFragment("TestFragment3"),TestFragment("TestFragment4"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.offscreenPageLimit = 3
        viewPager.adapter = myAdapter(supportFragmentManager)
        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavBar.setOnCreateContextMenuListener(View.OnCreateContextMenuListener(
            { menu, v, menuInfo -> Log.i("fff", "ssssss") }

        ))

        bottomNavBar.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> viewPager.currentItem = 0
                R.id.tool -> viewPager.currentItem = 1
                R.id.my -> viewPager.currentItem = 2
                R.id.my2 -> viewPager.currentItem = 3
                R.id.my3-> viewPager.currentItem = 4

            }
            false
        })

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

                when (position) {
                    0 -> bottomNavBar.menu.findItem(R.id.home).isChecked = true
                    1 -> bottomNavBar.menu.findItem(R.id.tool).isChecked = true
                    2 -> bottomNavBar.menu.findItem(R.id.my).isChecked = true
                    3 -> bottomNavBar.menu.findItem(R.id.my2).isChecked = true
                    4 -> bottomNavBar.menu.findItem(R.id.my3).isChecked = true

                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
    }

    inner class myAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getCount(): Int {
            return fragmentList.count()
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }


    }
}