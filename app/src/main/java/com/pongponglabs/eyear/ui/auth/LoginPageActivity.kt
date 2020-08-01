package com.pongponglabs.eyear.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.MainActivity
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        loginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        registerBtn.setOnClickListener{
            val intent = Intent(this, RegisterPageActivity::class.java)
            startActivity(intent)
        }

        forgotPassword.setOnClickListener{
            val intent = Intent(this, FindPasswordActivity::class.java)
            startActivity(intent)
        }

    }
}