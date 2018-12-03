package com.example.sangs.finalprojectkade.Model.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitResponse {

    val url:String = "https://www.thesportsdb.com/api/v1/json/1/"
    fun response():APIClientRetrofit{
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(APIClientRetrofit::class.java)
    }

}