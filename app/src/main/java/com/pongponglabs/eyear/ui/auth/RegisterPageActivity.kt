package com.pongponglabs.eyear.ui.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
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
import kotlinx.android.synthetic.main.activity_register_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterPageActivity : AppCompatActivity() {
    val PREFERENCE = "pref_data"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)
        val pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE)



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

        val adapter1= ArrayAdapter(this, android.R.layout.simple_list_item_1, university)
        mySpinner1.adapter=adapter1

        mySpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                println(university[position])
                val universitySelected = mySpinner1.selectedItem.toString()
                Log.d("Spinner1", universitySelected)
            }
            override fun onNothingSelected(adapterView: AdapterView<*>) {
                Log.d("LOGD", "NothingSelected")
            }
        }

        val department = arrayOf("경영학과", "기계공학과", "디자인학과", "의생명융합공학부", "정보컴퓨터공학")

        val mySpinner2 = findViewById<Spinner>(R.id.register_department_spinner)

        val adapter2= ArrayAdapter(this, android.R.layout.simple_list_item_1, department)
        mySpinner2.adapter=adapter2
        mySpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                println(department[i])
                val departmentSelected = mySpinner2.selectedItem.toString()
                Log.d("Spinner2", departmentSelected)
            }
            override fun onNothingSelected(adapterView: AdapterView<*>) {
                Log.d("LOGD", "NothingSelected")
            }
        }
    }

    private fun join() {
        val pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE)
        val editor = pref.edit()

        if(inputRegisterName.text.toString() != "" && inputRegisterId.text.toString() != "" && inputRegisterEmail.text.toString() != ""  && inputRegisterPassword.text.toString() != "" && inputRegisterPasswordValidator.text.toString() != "") {
            editor.putString("name", inputRegisterName.text.toString())
            editor.putString("uid", inputRegisterId.text.toString())
            editor.putString("email", inputRegisterEmail.text.toString())
            editor.putString("password", inputRegisterPassword.text.toString())
            editor.putString("passwordValidator", inputRegisterPasswordValidator.text.toString())
            editor.apply()
            Log.d("Log: ", pref.getString("name", "") + pref.getString("uid", "") + pref.getString("email", "") + pref.getString("password", "") + pref.getString("passwordValidator", "")
            )
        }


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
        join["dept"] = 3



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

        if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(passwordValidator)) {
            RetrofitClient.retrofitService.join(join).enqueue(object : Callback<Users> {
                override fun onResponse(call: Call<Users>?, response: Response<Users>?) {
                    when (response!!.code()) {
                        200 -> {
                            editor.apply()
                            Toast.makeText(
                                this@RegisterPageActivity,
                                "회원가입에 성공했습니다.",
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

    private fun setDept(position: String) {
        when(position){
            "정보컴퓨터공학부" -> 1
            "기계공학부" -> 2
            "의생명융합공학부" -> 3
            "전기공학부" -> 4
            else -> null
        }
    }
}