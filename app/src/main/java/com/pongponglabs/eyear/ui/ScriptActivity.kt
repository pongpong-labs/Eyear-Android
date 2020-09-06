package com.pongponglabs.eyear


import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent.ACTION_DOWN
import android.view.MotionEvent.ACTION_UP
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.pongponglabs.eyear.ui.fragment.MainFragment
import kotlinx.android.synthetic.main.activity_script.*
import java.lang.reflect.Type
import java.util.*


class ScriptActivity : AppCompatActivity() {
//    companion object {
//        private const val REQUEST_CODE_STT = 1
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_script)

        checkPermission()

        val textView = findViewById<TextView>(R.id.output)

        val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechRecognizerIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(bundle: Bundle) {}

            override fun onBeginningOfSpeech() {}

            override fun onRmsChanged(v: Float) {}

            override fun onBufferReceived(bytes: ByteArray) {}

            override fun onEndOfSpeech() {}

            override fun onError(i: Int) {}

            override fun onResults(bundle: Bundle) {
                val matches =
                    bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)//getting all the matches
                if (matches != null)
                    output.text = matches[0]
            }

            override fun onPartialResults(bundle: Bundle) {}

            override fun onEvent(i: Int, bundle: Bundle) {}
        })


        back_btn.setOnClickListener{
            val intent = Intent(this, MainFragment::class.java)
            startActivity(intent)
            finish()
        }

        btn_stt.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                ACTION_UP -> {
                    speechRecognizer.stopListening()
                    textView.hint = "Stopping..."
                }

                ACTION_DOWN -> {
                    speechRecognizer.startListening(speechRecognizerIntent)
                    textView.setText("")
                    textView.hint = "Listening..."
                }
            }
            false
            }
        )

        textSize_btn.setOnClickListener {
            val currentSize = textView.textSize
            Log.d("TAG", currentSize.toString())
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 150.0F)
        }
    }
//
//    private fun stt(){
//        val sttIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
//        sttIntent.putExtra(
//            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
//        )
//        sttIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
//        sttIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "말하세요!")
//        try {
//            startActivityForResult(sttIntent, REQUEST_CODE_STT)
//        } catch (e: ActivityNotFoundException) {
//            e.printStackTrace()
//            Toast.makeText(this, "Your device does not support STT.", Toast.LENGTH_LONG).show()
//        }
//    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when (requestCode) {
//            REQUEST_CODE_STT -> {
//                if (resultCode == Activity.RESULT_OK && data != null) {
//                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
//                    result?.let {
//                        val recognizedText = it[0]
//                        output.text = recognizedText
//                    }
//                }
//            }
//        }
//    }


    var permissionlistener: PermissionListener = object : PermissionListener {
        override fun onPermissionGranted() {

        }

        override fun onPermissionDenied(deniedPermissions: MutableList<String>) {

        }
    }

    private fun checkPermission(){
        TedPermission.with(this)
            .setPermissionListener(permissionlistener)
            .setRationaleMessage("앱의 기능을 사용하기 위해서는 권한이 필요합니다.")
            .setDeniedMessage("[설정] > [권한] 에서 권한을 허용할 수 있습니다.")
            .setPermissions(android.Manifest.permission.INTERNET,android.Manifest.permission.RECORD_AUDIO)
            .check()
    }
}