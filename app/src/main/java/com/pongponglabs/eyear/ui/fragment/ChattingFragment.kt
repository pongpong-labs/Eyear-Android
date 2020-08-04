package com.pongponglabs.eyear.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pongponglabs.eyear.R

class ChattingFragment : Fragment() {

    lateinit var mView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.activity_chatting_fragment, container, false)

        return mView
    }
}