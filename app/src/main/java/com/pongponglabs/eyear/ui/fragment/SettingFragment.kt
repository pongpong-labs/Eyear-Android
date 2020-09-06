package com.pongponglabs.eyear.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.account.AccountInfoActivity
import com.pongponglabs.eyear.ui.info.AppInfoActivity
import kotlinx.android.synthetic.main.activity_setting_fragment.view.*

class SettingFragment : Fragment() {
    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.activity_setting_fragment, container, false)


        mView.myInformationBtn.setOnClickListener {
            val intent = Intent(this@SettingFragment.context, AccountInfoActivity::class.java)
            startActivity(intent)
        }

        mView.appInfoBtn.setOnClickListener {
            val intent = Intent(this@SettingFragment.context, AppInfoActivity::class.java)
            startActivity(intent)
        }


        return mView

    }
}