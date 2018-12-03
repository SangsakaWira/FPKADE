package com.example.sangs.finalprojectkade.teams

import com.example.sangs.finalprojectkade.Model.model.ResponseValue
import com.example.sangs.finalprojectkade.Model.retrofit.RetrofitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamsPresenter(val view: TeamsView){

    fun getLeague(){
        val apiClientRetrofit = RetrofitResponse().response()
        apiClientRetrofit.getLeague().enqueue(object : Callback<ResponseValue>{
            override fun onFailure(call: Call<ResponseValue>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseValue>, response: Response<ResponseValue>) {
                val data = response.body()
                if (data != null){
                    view.showLeague(data.countrys)
                }
            }

        })
    }

}