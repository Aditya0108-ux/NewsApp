package com.adityaa0108.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface  ApiInterface {

    //interface of API - where we tell the request (GET,POST)

    @GET("top-headlines")

    fun getNews(@Query("country") country:String,
                @Query("pageSize") pageSize:Int,
                @Query("apikey") apiKey:String):Call<MainNews>

    @GET("top-headlines")
    fun getCategoryNews(@Query("country") country:String,
                @Query("category") category:String,
                @Query("pageSize") pageSize:Int,
                 @Query("apikey") apiKey:String):Call<MainNews>


}
