package com.pongponglabs.eyear.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.fragment.MainFragment
import kotlinx.android.synthetic.main.activity_save_script_dialog.*

class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        saveScriptBtn.setOnClickListener{
            val intent = Intent(this, MainFragment::class.java)
            Toast.makeText(this@FeedbackActivity, "스크립트가 저정되었습니다.", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }
}