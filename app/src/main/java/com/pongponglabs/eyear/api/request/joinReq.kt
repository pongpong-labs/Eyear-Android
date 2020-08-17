package com.pongponglabs.eyear.api.request

data class joinReq(
    val uid : String,
    val password : String,
    val role : String,
    val name : String,
    val email : String,
    val univ : String,
    val dept : String
)