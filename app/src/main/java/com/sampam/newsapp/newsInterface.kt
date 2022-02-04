package com.sampam.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface newsInterface {
    @GET("v2/top-headlines")
    fun getheadlines(@Query("country") country:String,@Query("apiKey") apiKey:String):Call<news>

    //through get function we send request url=
    // https://newsapi.org/v2/top-headlines?country=in&apiKey=39ca5b90a8c249319faa97ddcf9220ff
    //(******base url****)(*****url*******)(*******query*************************************)
}