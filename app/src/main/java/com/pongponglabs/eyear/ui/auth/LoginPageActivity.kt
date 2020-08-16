package com.pongponglabs.eyear.ui.auth

import android.content.Intent
import android.os.Bundle
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



    private fun login() {
    val login = HashMap<String, String>()
    login["uid"] = inputLoginId.text.toString()
    login["password"] = inputLoginPw.text.toString()
    loginBtn.isClickable = false
        RetrofitClient.retrofitService.logIn(login).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>?, response: Response<Users>?) {
                when (response!!.code()) {
                    200 -> {
                        startActivity(Intent(this@LoginPageActivity, MainActivity::class.java))
                        finish()
                    }
                    400 -> {
                        loginBtn.isClickable = true
                        Toast.makeText(this@LoginPageActivity, "존재하지 않습니다. 아이디 또는 비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            override fun onFailure(call: Call<Users>?, t: Throwable?) {

            }
        })
    }
}