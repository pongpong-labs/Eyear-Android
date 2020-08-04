package com.pongponglabs.eyear.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.fragment.message.AlertFragment
import com.pongponglabs.eyear.ui.fragment.message.MessageFragment
import kotlinx.android.synthetic.main.activity_chatting_fragment.*

class ChattingFragment : Fragment() {

    lateinit var mView: View
    private var mViewPager: ViewPager? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        mView = inflater.inflate(R.layout.activity_chatting_fragment, container, false)

        val fragmentManager = (activity)!!.supportFragmentManager
        mViewPager = view!!.findViewById(R.id.viewpager)
        mViewPager!!.adapter =
            PagerAdapter(
                fragmentManager
            )
        mViewPager!!.currentItem = 1

        val tabLayout = view!!.findViewById<View>(R.id.tabLayout) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)

        tabLayout.getTabAt(0)!!.setText("메세지")
        tabLayout.getTabAt(1)!!.setText("알림")
        mViewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) = tab.select()
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        return mView
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