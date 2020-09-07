package com.pongponglabs.eyear.ui.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pongponglabs.eyear.R

class ChatAdapter(val context: Context, val chatList: ArrayList<Chat>) : RecyclerView.Adapter<ChatAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_rv_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(chatList[position], context)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val professorimg = itemView?.findViewById<ImageView>(R.id.professorPhotoImg)
        val classname = itemView?.findViewById<TextView>(R.id.classNameTxt)
        val message = itemView?.findViewById<TextView>(R.id.messageTxt)
        val datetime = itemView?.findViewById<TextView>(R.id.datetimeTxt)

        fun bind (chat: Chat, context: Context) {
            if (chat.profile != "") {
                val resourceId = context.resources.getIdentifier(chat.profile, "drawable", context.packageName)
                professorimg?.setImageResource(resourceId)
            } else {
                professorimg?.setImageResource(R.mipmap.ic_launcher)
            }
            classname?.text = chat.className
            message?.text = chat.message
            datetime?.text = chat.datetime
        }
    }
}