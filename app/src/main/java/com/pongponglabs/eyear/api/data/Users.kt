package com.pongponglabs.eyear.api.data

data class Users(
    val resultCode : String,
    val resultMessage : String,
    val `data`: Data,
    val name : String,
    val token : String
)