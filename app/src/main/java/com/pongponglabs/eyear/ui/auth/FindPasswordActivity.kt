package com.pongponglabs.eyear.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.api.RetrofitClient
import com.pongponglabs.eyear.api.data.Users
import com.pongponglabs.eyear.ui.MainActivity
import kotlinx.android.synthetic.main.activity_find_password.*
import kotlinx.android.synthetic.main.activity_login_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FindPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_password)

        resetPasswordBtn.setOnClickListener{
            findPw()
        }
    }



    private fun findPw() {
        val findPassword = HashMap<String, String>()
        findPassword["uid"] = inputResetId.text.toString().trim()
        findPassword["name"] = inputResetName.text.toString().trim()
        findPassword["email"] = inputResetEmail.text.toString().trim()

        RetrofitClient.retrofitService.findPw(findPassword).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>?, response: Response<Users>?) {
                when (response!!.code()) {
                    200 -> {
                        Toast.makeText(this@FindPasswordActivity, "비밀번호 변경 이메일을 요청했습니다. 가입하신 이메일 수신함을 확인해주세요.", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@FindPasswordActivity, MainActivity::class.java))
                        finish()
                    }
                    else -> {
                        Toast.makeText(this@FindPasswordActivity, "요청에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            override fun onFailure(call: Call<Users>?, t: Throwable?) {

            }
        })
    }
}