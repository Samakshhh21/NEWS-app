package com.sampam.newsapp

data class news(
    val totalResults:Int,
    val articles:List<article>
)
data class article(
    val title:String,
    val description:String,
    val urlToImage:String,
    val content:String
)

