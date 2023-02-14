package com.example.newsapplicationwithviewpager

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET(value = "b08e9fc7-cafe-4c66-8eb1-524de9395f0f")
    fun getData(): Call<List<MyDataItem>>
}