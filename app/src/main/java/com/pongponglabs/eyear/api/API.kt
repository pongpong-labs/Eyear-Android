package com.pongponglabs.eyear.api

import com.pongponglabs.eyear.api.data.Users
import retrofit2.Call
import retrofit2.http.*

interface API {

    // 기본 데이터 관련 기능
    @GET("/info/lecture")
    fun infoLecture(@Query("dept_idx") dept_idx : Int) : Call<Users>

    @GET("/info/university")
    fun infoUniv() : Call<Users>

    @GET("/info/department")
    fun infoDept(@Query("univ_idx") univ_idx : Int) : Call<Users>

    // 학생 - 강의 관련 기능
    @POST("student/lecture")
    @FormUrlEncoded
    fun studentAddLecture(@Field("lec_details_idx") lec_details_idx : Int) : Call<Users>

    @DELETE("/student/lecture")
    fun studentDeleteLecture(@Path("lec_details_idx") lec_details_idx: Int) : Call<Users>

    @GET("/student/lecture/script")
    fun studentLectureAddScript(@Query("lec_details_idx") lec_details_idx: Int) : Call<Users>

    @PUT("/student/lecture/script")
    fun studentLectureEditScript(@Body lec_details_idx : Int,
                                 week : Int,
                                 num_per_week : Int,
                                 summary : String,
                                 script : String)

    @POST("/student/script")
    @FormUrlEncoded
    fun lectureAddScript(@Field("lec_details_idx") lec_details_idx : Int,
                         @Field("week") week : Int,
                         @Field("num_per_week") num_per_week : Int,
                         @Field("summary") summary: String,
                         @Field("script") script: String,
                         @Field("feedback") feedback : String
    ) : Call<Users>

    @GET("student/lecture/all")
    fun studentLectureAll()
    //TODO

    @GET("student/lecture/summary")
    fun studentLectureSummary()
    //TODO



    // 회원 정보 관리 및 로그인 관련 기능
    @POST("/member/join")
    @FormUrlEncoded
    fun join(@Field("uid") id : String,
             @Field("password") pw: String,
             @Field("role") role: String,
             @Field("name") name : String,
             @Field("email") email : String,
             @Field("univ") univ : Int,
             @Field("dept") dept : Int)
            : Call<Users>

    @GET("/member/logout")
    fun logout(@Header("Authorization") token : String) : Call<Users>


    @POST("/member/login")
    @FormUrlEncoded
    fun logIn(@Field("uid") id : String,
              @Field("password") pw : String) : Call<Users>

    @GET("/member/check/id")
    fun checkId(@Query("uid") uid: String) : Call<Users>

    @GET("/member/check/email")
    fun checkEmail(@Query("email") email: String) : Call<Users>


    @POST("/member/find/id")
    @FormUrlEncoded
    fun findId(@Field("name") name : String,
               @Field("email") email: String) : Call<Users>

    @POST("/member/check/pw")
    @FormUrlEncoded
    fun checkPw(@Field("idx") idx : Int,
                @Field("password") password : String) : Call<Users>

    @POST("/member/change/pw")
    @FormUrlEncoded
    fun changePw(@Field("idx") idx : Int,
                 @Field("new_pw") new_pw: String) : Call<Users>

    @POST("/member/init/pw")
    @FormUrlEncoded
    fun findPw(@Field("uid") id : String,
               @Field("name") name : String,
               @Field("email") email: String) : Call<Users>
}