package com.pongponglabs.eyear.api

import com.pongponglabs.eyear.api.data.Users
import retrofit2.Call
import retrofit2.http.*

interface API {

    @GET("/info/dept")
    @FormUrlEncoded
    fun infoDept(@Field("univ_idx") univ_idx : Int) : Call<Users>

    @GET("/info/univ")
    @FormUrlEncoded
    fun infoUniv(@Field("univ_idx") univ_idx : Int) : Call<Users>

    @POST("/member/change/pw")
    @FormUrlEncoded
    fun changePw(@Field("idx") idx : Int, @Field("new_pw") new_pw: String) : Call<Users>

    @GET("/member/check/email")
    @FormUrlEncoded
    fun checkEmail(@Field("email") email: String) : Call<Users>

    @GET("/member/check/id")
    @FormUrlEncoded
    fun checkId(@Field("uid") uid: String) : Call<Users>

    @POST("/member/check/pw")
    @FormUrlEncoded
    fun checkPw(@Field("idx") idx : Int, @Field("password") password : String) : Call<Users>

    @POST("/member/find/id")
    @FormUrlEncoded
    fun findId(@Field("name") name : String, @Field("email") email: String) : Call<Users>

    @POST("/member/init/pw")
    @FormUrlEncoded
    fun findPw(@Field("uid") id : String, @Field("name") name : String, @Field("email") email: String) : Call<Users>

    @POST("/member/join")
    @FormUrlEncoded
    fun join(@Field("uid") id : String, @Field("password") pw: String, @Field("role") role: String,
                 @Field("name") name : String, @Field("email") email : String, @Field("univ") univ : Int, @Field("dept") dept : Int)
            : Call<Users>

    @POST("/member/login")
    @FormUrlEncoded
    fun logIn(@Field("uid") id : String, @Field("password") pw : String) : Call<Users>

    @GET("/member/logout")
    @FormUrlEncoded
    fun logout(@Header("Authorization") token : String) : Call<Users>

}