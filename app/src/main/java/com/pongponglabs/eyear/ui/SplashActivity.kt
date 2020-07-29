package com.pongponglabs.eyear.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.auth.LoginPageActivity

class SplashActivity : AppCompatActivity() {

    val SPLASH_TIME: Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginPageActivity::class.java))
            finish()

        }, SPLASH_TIME)
    }
}
