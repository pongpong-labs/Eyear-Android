package com.pongponglabs.eyear.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.fragment.MainFragment
import kotlinx.android.synthetic.main.activity_add_class.*

class AddClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_class)

        val dept = arrayOf("경영학과", "기계공학과", "디자인학과", "의생명융합공학부", "정보컴퓨터공학부")

        val mySpinner1 = findViewById<Spinner>(R.id.dept)

        val adapter1= ArrayAdapter(this, android.R.layout.simple_list_item_1, dept)
        mySpinner1.adapter=adapter1

        mySpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {

            }
            override fun onNothingSelected(adapterView: AdapterView<*>) {
                Log.d("LOGD", "NothingSelected")
            }
        }


        val univClass = arrayOf("부산대학교", "부산가톨릭대학교", "부산교육대학교", "부산여자대학교", "부산외국어대학교")

        val mySpinner2 = findViewById<Spinner>(R.id.univ_class)

        val adapter2= ArrayAdapter(this, android.R.layout.simple_list_item_1, univClass)
        mySpinner2.adapter=adapter2

        mySpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {

            }
            override fun onNothingSelected(adapterView: AdapterView<*>) {
                Log.d("LOGD", "NothingSelected")
            }
        }

        addClassFinishBtn.setOnClickListener{
            val intent = Intent(this, MainActivity()::class.java)
            startActivity(intent)
            finish()
        }
    }
}