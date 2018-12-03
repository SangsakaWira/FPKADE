package com.example.sangs.finalprojectkade.Model.retrofit

import com.example.sangs.finalprojectkade.Model.model.ResponseValue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface APIClientRetrofit {


    @GET("search_all_leagues.php?s=Soccer")
    fun getLeague(): Call<ResponseValue>

}