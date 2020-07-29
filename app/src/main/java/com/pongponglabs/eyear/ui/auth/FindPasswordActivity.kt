package com.pongponglabs.eyear.ui.auth

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.pongponglabs.eyear.R


class FindPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_password)


        val actionBar: ActionBar? = supportActionBar //제목줄 객체 얻어오기
        actionBar?.setDisplayHomeAsUpEnabled(true) //업버튼 <- 만들기


    }
}