package com.sampam.newsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object newsService {
    val retrofit=Retrofit.Builder()
        .baseUrl(constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val newsinterface:newsInterface= retrofit.create(newsInterface::class.java)
}