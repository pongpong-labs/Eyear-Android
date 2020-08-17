package com.pongponglabs.eyear.ui


import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.fragment.ChattingFragment
import com.pongponglabs.eyear.ui.fragment.MainFragment
import com.pongponglabs.eyear.ui.fragment.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView.setOnNavigationItemSelectedListener(this)
        navigationView.itemIconTintList = null;
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,MainFragment()).commit()
    }


    override fun onNavigationItemSelected(menu: MenuItem): Boolean {
        when (menu.itemId) {
            R.id.searchItem -> {
                val mainFragment = MainFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, mainFragment).commit()
            }
            R.id.chatItem -> {
                val chattingFragment = ChattingFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, chattingFragment).commit()
            }
            R.id.settingItem -> {
                val settingFragment = SettingFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, settingFragment).commit()
            }
        }
        return false
    }
}