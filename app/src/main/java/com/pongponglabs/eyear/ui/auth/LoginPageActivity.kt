package com.pongponglabs.eyear.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pongponglabs.eyear.R
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        forgotPassword.setOnClickListener{
            val intent = Intent(this, FindPasswordActivity::class.java)
            startActivity(intent)
        }

    }
}