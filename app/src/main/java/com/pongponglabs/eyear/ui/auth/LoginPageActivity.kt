package com.pongponglabs.eyear.ui.auth

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.api.RetrofitClient
import com.pongponglabs.eyear.api.data.Users
import com.pongponglabs.eyear.ui.MainActivity
import kotlinx.android.synthetic.main.activity_login_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPageActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)


        loginBtn.setOnClickListener {
            login()
        }

        registerBtn.setOnClickListener{
            val intent = Intent(this, RegisterPageActivity::class.java)
            startActivity(intent)
        }

        forgotPassword.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("아이디, 비밀번호를 잊으셨나요?")
            builder.setNegativeButton("취소", null)
                .create()
            val v1 = layoutInflater.inflate(R.layout.activity_find_auth_dialog, null)
            builder.setView(v1)
            val btn1: AppCompatButton? = v1.findViewById(R.id.findIdBtn)
            val btn2: AppCompatButton? = v1.findViewById(R.id.findPasswordBtn)


            btn1!!.setOnClickListener{
                val intent = Intent(this, FindIdActivity::class.java)
                startActivity(intent)
            }

            btn2!!.setOnClickListener{
                val intent = Intent(this, FindPasswordActivity::class.java)
                startActivity(intent)
            }

            builder.show()
        }
    }


    var time3: Long = 0
    override fun onBackPressed() {
        val time1 = System.currentTimeMillis()
        val time2 = time1 - time3
        if (time2 in 0..2000) {
            finish()
        }
        else {
            time3 = time1
            Toast.makeText(applicationContext, "한번 더 누르시면 종료됩니다.",Toast.LENGTH_SHORT).show()
        }
    }


    private fun login() {
        val uid =  inputLoginId.text.toString()
        val password = inputLoginPw.text.toString()

        val login = HashMap<String, String>()
        login["uid"] = inputLoginId.text.toString().trim()
        login["password"] = inputLoginPw.text.toString().trim()

        if(TextUtils.isEmpty(uid)){
            inputLoginId.error = "아이디를 입력하세요."
            inputLoginId.setBackgroundColor(Color.WHITE)
            inputLoginId.setTextColor(Color.BLACK)
        }
        if(TextUtils.isEmpty(password)){
            inputLoginPw.error = "비밀번호를 입력하세요."
            inputLoginId.setBackgroundColor(Color.WHITE)
            inputLoginId.setTextColor(Color.BLACK)
        }
        if(!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(password)) {
            RetrofitClient.retrofitService.logIn(login).enqueue(object : Callback<Users> {
                override fun onResponse(call: Call<Users>?, response: Response<Users>?) {
                    when (response!!.code()) {
                        200 -> {
                            Toast.makeText(
                                this@LoginPageActivity,
                                "반갑습니다 ${response.body()!!.name} 님",
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(Intent(this@LoginPageActivity, MainActivity::class.java))
                            finish()
                        }
                        400 -> {
                            Toast.makeText(
                                this@LoginPageActivity,
                                "존재하지 않은 사용자입니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

                override fun onFailure(call: Call<Users>?, t: Throwable?) {

                }
            })

        }
    }
}