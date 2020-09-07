package com.pongponglabs.eyear.ui.fragment.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pongponglabs.eyear.R
import com.pongponglabs.eyear.ui.chat.Chat
import com.pongponglabs.eyear.ui.chat.ChatAdapter
import kotlinx.android.synthetic.main.fragment_message.view.*

class MessageFragment : Fragment() , View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_message, container, false)

        val chatList = arrayListOf<Chat>(
            Chat("", "UX/UI 디자인", "성적 좋게 주세요", "2020.09.20 09:15"),
            Chat("", "공학수학", "성적 좋게 주세요", "2020.09.18 09:15"),
            Chat("", "생명과학2", "성적 좋게 주세요", "2020.09.13 09:15"),
            Chat("", "노벨상속의생명과학", "성적 좋게 주세요", "2020.09.01 09:15")
        )


        rootView.message_recyclerview.apply {
            adapter = ChatAdapter(requireContext(), chatList)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        return rootView
    }

    override fun onClick(p0: View?) {
    }
}
