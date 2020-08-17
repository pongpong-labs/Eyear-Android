package com.pongponglabs.eyear.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.pongponglabs.eyear.R
import kotlinx.android.synthetic.main.activity_register_page.*

class RegisterPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        back_btn.setOnClickListener{
            val intent = Intent(this, LoginPageActivity::class.java)
            startActivity(intent)
            finish()
        }


        val university = arrayOf("부산대학교", "부산가톨릭대학교", "부산교육대학교", "부산여자대학교", "부산외국어대학교")

        val mySpinner1 = findViewById<Spinner>(R.id.register_univ_spinner)

        val adapter1= ArrayAdapter(this,android.R.layout.simple_list_item_1,university)
        mySpinner1.adapter=adapter1

        mySpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                println(university[i])
            }
            override fun onNothingSelected(adapterView: AdapterView<*>) {
            }
        }

        val department = arrayOf("경영학과","기계공학과","디자인학과","의생명융합공학부","정보컴퓨터공학")

        val mySpinner2 = findViewById<Spinner>(R.id.register_department_spinner)

        val adapter2= ArrayAdapter(this,android.R.layout.simple_list_item_1,department)
        mySpinner2.adapter=adapter2

        mySpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                println(department[i])
            }
            override fun onNothingSelected(adapterView: AdapterView<*>) {
            }
        }
    }
}