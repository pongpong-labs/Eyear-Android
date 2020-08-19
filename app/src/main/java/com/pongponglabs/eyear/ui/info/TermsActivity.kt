package com.pongponglabs.eyear.ui.info

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.fragment.SettingFragment
import kotlinx.android.synthetic.main.activity_app_info.*

class TermsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)

        back_btn.setOnClickListener{
            val intent = Intent(this, AppInfoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}