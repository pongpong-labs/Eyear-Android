package com.pongponglabs.eyear.ui.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pongponglabs.eyear.R
import kotlinx.android.synthetic.main.activity_account_info.*

class AccountInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_info)

        profileSettingBtn.setOnClickListener{
            val intent = Intent(this, ProfileSettingActivity::class.java)
            startActivity(intent)
        }

        passwordChangeBtn.setOnClickListener{
            val intent = Intent(this, PasswordChangeActivity::class.java)
            startActivity(intent)
        }

        secessionBtn.setOnClickListener{
            val intent = Intent(this, SecessionActivity::class.java)
            startActivity(intent)

        }
    }
}