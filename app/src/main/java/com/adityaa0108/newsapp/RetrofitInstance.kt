package com.adityaa0108.newsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
      // lateinit var retrofit:Retrofit  //object of retrofit is created to access Retrofit library

       private val retrofit by lazy{ //object is intialize when it is first used
              Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(GsonConverterFactory.create()).build() //retrofit is build here
       }

      val apiInterface by lazy{         //this is api object which will help us to make network request
             retrofit.create(ApiInterface::class.java)
      }


}
