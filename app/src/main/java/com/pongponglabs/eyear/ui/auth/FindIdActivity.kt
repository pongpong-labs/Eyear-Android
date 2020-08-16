package com.pongponglabs.eyear.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.api.RetrofitClient
import com.pongponglabs.eyear.api.data.Users
import com.pongponglabs.eyear.api.data.findPw
import com.pongponglabs.eyear.ui.MainActivity
import kotlinx.android.synthetic.main.activity_find_id.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FindIdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id)

        findId2Btn.setOnClickListener{
            findId()
        }
    }

    private fun findId() {
        val findId = HashMap<String, String>()
        findId["name"] = inputFindName.text.toString().trim()
        findId["email"] = inputFindEmail.text.toString().trim()

        RetrofitClient.retrofitService.findId(findId).enqueue(object : Callback<findPw> {
            override fun onResponse(call: Call<findPw>?, response: Response<findPw>?) {
                when (response!!.code()) {
                    200 -> {
                        Toast.makeText(this@FindIdActivity, "${response.body()!!.data} 입니다.", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this@FindIdActivity, LoginPageActivity::class.java))
                        finish()
                    }
                    else -> {
                        Toast.makeText(this@FindIdActivity, "요청에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            override fun onFailure(call: Call<findPw>?, t: Throwable?) {

            }
        })
    }
}