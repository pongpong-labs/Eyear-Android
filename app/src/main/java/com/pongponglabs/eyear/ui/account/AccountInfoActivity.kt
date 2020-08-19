package com.pongponglabs.eyear.ui.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.api.RetrofitClient
import com.pongponglabs.eyear.api.data.Users
import com.pongponglabs.eyear.ui.auth.LoginPageActivity
import kotlinx.android.synthetic.main.activity_account_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_info)

        profileSettingBtn.setOnClickListener{
            val intent = Intent(this, ProfileSettingActivity::class.java)
            startActivity(intent)
        }

        logoutBtn.setOnClickListener{
            logout()
        }
        passwordChangeBtn.setOnClickListener{
            val intent = Intent(this, PasswordChangeActivity::class.java)
            startActivity(intent)
        }

        secessionBtn.setOnClickListener{
            val intent = Intent(this, SecessionActivity::class.java)
            startActivity(intent)

        }
    }

    private fun logout() {
        val logout = HashMap<String, String>()
        logout["Authorization"] = "Bearer " + "token"
        RetrofitClient.retrofitService.logout(logout).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>?, response: Response<Users>?) {
                when (response!!.code()) {
                    200 -> {
                        Toast.makeText(this@AccountInfoActivity, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@AccountInfoActivity, LoginPageActivity::class.java))
                        finish()
                    }
                    else -> {
                        Toast.makeText(this@AccountInfoActivity, "로그아웃에 실패습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            override fun onFailure(call: Call<Users>?, t: Throwable?) {

            }
        })
    }
}