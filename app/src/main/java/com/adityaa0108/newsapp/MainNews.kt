package com.adityaa0108.newsapp

data class MainNews(
    val status:String,
    val totalResults:Int,
            val articles:List<ModelClass>
)