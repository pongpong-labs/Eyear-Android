package com.pongponglabs.eyear.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.ScriptActivity
import kotlinx.android.synthetic.main.activity_main_fragment.view.*

class MainFragment : Fragment() {
    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.activity_main_fragment, container, false)

        mView.fab.setOnClickListener{
            val intent = Intent(this@MainFragment.context, ScriptActivity::class.java)
            startActivity(intent)
        }

        return mView
    }
}