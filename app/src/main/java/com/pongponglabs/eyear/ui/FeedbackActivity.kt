package com.pongponglabs.eyear.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.fragment.MainFragment
import kotlinx.android.synthetic.main.activity_feedback.*

class FeedbackActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)


        saveSttBtn.setOnClickListener {
            Toast.makeText(this@FeedbackActivity, "스크립트가 저정되었습니다.", Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(this)
            val v1 = layoutInflater.inflate(R.layout.activity_save_script_dialog, null)
            builder.setView(v1)
            val btn1: Button? = v1.findViewById(R.id.saveScriptBtn)

            btn1!!.setOnClickListener {
                val transaction = manager.beginTransaction()
                val fragment = MainFragment()
                transaction.replace(R.id.frameLayout, fragment)
                transaction.addToBackStack(null)
                transaction.commit()


            }

            builder.show()
        }
    }
}