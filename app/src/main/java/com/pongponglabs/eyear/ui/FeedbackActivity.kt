package com.pongponglabs.eyear.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pongponglabs.eyear.R
import kotlinx.android.synthetic.main.activity_feedback.*

class FeedbackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        btn_stt.setOnClickListener{
            val intent = Intent(this, ScriptActivity::class.java)
            startActivity(intent)
            finish()
        }

        saveSttBtn.setOnClickListener {
            Toast.makeText(this@FeedbackActivity, "스크립트가 저정되었습니다.", Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(this)
            val v1 = layoutInflater.inflate(R.layout.activity_save_script_dialog, null)
            builder.setView(v1)
            val btn1: Button? = v1.findViewById(R.id.saveScriptBtn)

            btn1!!.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            builder.show()
        }
    }
}