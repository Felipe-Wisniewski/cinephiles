package com.kobe.cinephiles.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kobe.cinephiles.R
import com.kobe.cinephiles.view.upcoming.UpcomingListDbFragment
import com.kobe.cinephiles.view.upcoming.UpcomingListWebFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(Color.WHITE)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        tabs.setupWithViewPager(viewPager)
    }

    inner class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment {
            return if (position == 0) {
                UpcomingListWebFragment()
            } else {
                UpcomingListDbFragment()
            }
        }

        override fun getCount(): Int = 2

        override fun getPageTitle(position: Int): CharSequence? {
            return if (position == 0) {
                getString(R.string.tab_upcoming)
            } else {
                getString(R.string.tab_favorites)
            }
        }
    }
}
