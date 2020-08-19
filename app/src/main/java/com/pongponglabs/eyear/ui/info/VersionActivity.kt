package com.pongponglabs.eyear.ui.info

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pongponglabs.eyear.R
import kotlinx.android.synthetic.main.activity_register_page.*

class VersionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_version)

        back_btn.setOnClickListener{
            val intent = Intent(this, AppInfoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}