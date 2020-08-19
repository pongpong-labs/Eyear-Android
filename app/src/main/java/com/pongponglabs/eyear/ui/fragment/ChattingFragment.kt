package com.pongponglabs.eyear.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.fragment.message.AlertFragment
import com.pongponglabs.eyear.ui.fragment.message.MessageFragment

class ChattingFragment : Fragment() {

    private var mViewPager: ViewPager? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.activity_chatting_fragment, container, false)

        val fragmentManager = (activity)!!.supportFragmentManager
        mViewPager = view.findViewById(R.id.viewpager)
        mViewPager!!.adapter =
            PagerAdapter(
                fragmentManager
            )
        mViewPager!!.currentItem = 0

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(mViewPager)

        tabLayout.getTabAt(0)!!.text = "메세지"
        tabLayout.getTabAt(1)!!.text = "알림"
        mViewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) = tab.select()
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        return view
    }
    class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getItem(position: Int): Fragment {

            return when (position) {
                0 ->
                    MessageFragment()
                1 ->
                    AlertFragment()
                else ->
                    AlertFragment()
            }
        }

        override fun getCount(): Int = 2
    }
}