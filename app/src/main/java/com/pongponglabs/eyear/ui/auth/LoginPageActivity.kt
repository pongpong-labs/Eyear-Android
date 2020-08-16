package com.pongponglabs.eyear.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.MainActivity
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPageActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        loginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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
}