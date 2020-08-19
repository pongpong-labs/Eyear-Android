package com.pongponglabs.eyear.ui.auth

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.api.RetrofitClient
import com.pongponglabs.eyear.api.data.Users
import com.pongponglabs.eyear.ui.MainActivity
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.activity_register_page.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)


        back_btn.setOnClickListener{
            val intent = Intent(this, LoginPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        registerPageBtn.setOnClickListener{
            join()

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

    private fun join() {
        val name = inputRegisterName.text.toString()
        val uid = inputRegisterId.text.toString()
        val email = inputRegisterEmail.text.toString()
        val password = inputRegisterPassword.text.toString()
        val passwordValidator = inputRegisterPasswordValidator.text.toString()

        val join = HashMap<String, Any>()
        join["name"] = inputRegisterName.text.toString().trim()
        join["uid"] = inputRegisterId.text.toString().trim()
        join["email"] = inputRegisterEmail.text.toString().trim()
        join["password"] = inputRegisterPassword.text.toString().trim()
        join["role"] = "ROLE_STUDENT"
        join["univ"] = 1
        join["dept"] = 1


        if (TextUtils.isEmpty(name)) {
            inputRegisterName.error = "이름을 입력하세요."
        }
        if (TextUtils.isEmpty(uid)) {
            inputRegisterId.error = "아이디를 입력하세요."
        }
        if (TextUtils.isEmpty(email)) {
            inputRegisterEmail.error = "이메일를 입력하세요."
        }
        if (TextUtils.isEmpty(password)) {
            inputRegisterPassword.error = "비밀번호를 입력하세요."
        }
        if (TextUtils.isEmpty(passwordValidator)){
            inputRegisterPasswordValidator.error = "비밀번호를 입력하세요"
        }

        if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(password)  && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(passwordValidator)) {
            RetrofitClient.retrofitService.join(join).enqueue(object : Callback<Users> {
                override fun onResponse(call: Call<Users>?, response: Response<Users>?) {
                    when (response!!.code()) {
                        200 -> {
                            Toast.makeText(
                                this@RegisterPageActivity,
                                "회원가입에 성공했습니다. ${response.body()!!.name} 님",
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(
                                Intent(
                                    this@RegisterPageActivity,
                                    MainActivity::class.java
                                )
                            )
                            finish()
                        }
                        400 -> {
                            Toast.makeText(
                                this@RegisterPageActivity,
                                "오류가 발생하였습니다.",
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