package com.pongponglabs.eyear.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient{

    private const val BASE_URL = "http://54.234.126.30"
    private var retrofitService: API

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val logger =
            OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS).build()


        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(logger)
            .build()

        retrofitService = retrofit.create(API::class.java)
    }
}