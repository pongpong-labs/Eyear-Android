package com.pongponglabs.eyear.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.fragment.ChattingFragment
import com.pongponglabs.eyear.ui.fragment.MainFragment
import com.pongponglabs.eyear.ui.fragment.SettingFragment


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<BottomNavigationView>(R.id.navigationView)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = MainFragment()
        addFragment(fragment)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.searchItem -> {
                val fragment = MainFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.chatItem -> {
                val fragment = ChattingFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.settingItem -> {
                val fragment = SettingFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}