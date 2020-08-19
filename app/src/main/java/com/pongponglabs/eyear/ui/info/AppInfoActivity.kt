package com.pongponglabs.eyear.ui.info

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.auth.LoginPageActivity
import com.pongponglabs.eyear.ui.auth.RegisterPageActivity
import com.pongponglabs.eyear.ui.fragment.SettingFragment
import kotlinx.android.synthetic.main.activity_app_info.*
import kotlinx.android.synthetic.main.activity_app_info.back_btn
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.activity_register_page.*

class AppInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_info)

        back_btn.setOnClickListener{
            val intent = Intent(this, SettingFragment::class.java)
            startActivity(intent)
            finish()
        }

        appVersionBtn.setOnClickListener{
            val intent = Intent(this, VersionActivity::class.java)
            startActivity(intent)
        }

        termsBtn.setOnClickListener{
            val intent = Intent(this, TermsActivity::class.java)
            startActivity(intent)
        }

        openSourceBtn.setOnClickListener{
            val intent = Intent(this, OpensourceActivity::class.java)
            startActivity(intent)
        }

        privacyBtn.setOnClickListener{
            val intent = Intent(this, PrivacyActivity::class.java)
            startActivity(intent)
        }


    }
}