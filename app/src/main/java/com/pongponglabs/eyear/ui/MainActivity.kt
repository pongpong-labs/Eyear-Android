package com.pongponglabs.eyear.ui


import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.pongponglabs.eyear.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    companion object {
        private const val REQUEST_CODE_STT = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()

        btn_stt.setOnClickListener {
            val sttIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            sttIntent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            sttIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            sttIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "말하세요!")


            try {
                startActivityForResult(sttIntent,
                    REQUEST_CODE_STT
                )
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
                Toast.makeText(this, "Your device does not support STT.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_STT -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    result?.let {
                        val recognizedText = it[0]
                        output.setText(recognizedText)
                    }
                }
            }
        }
    }


    var permissionlistener: PermissionListener = object : PermissionListener {
        override fun onPermissionGranted() {

        }

        override fun onPermissionDenied(deniedPermissions: MutableList<String>) {

        }
    }

    fun checkPermission(){
        TedPermission.with(this)
            .setPermissionListener(permissionlistener)
            .setRationaleMessage("앱의 기능을 사용하기 위해서는 권한이 필요합니다.")
            .setDeniedMessage("[설정] > [권한] 에서 권한을 허용할 수 있습니다.")
            .setPermissions(android.Manifest.permission.INTERNET,android.Manifest.permission.RECORD_AUDIO)
            .check()
    }
}


