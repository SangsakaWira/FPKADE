package com.example.sangs.finalprojectkade.matches.menu.next

import com.example.sangs.finalprojectkade.Model.model.ResponseValue
import com.example.sangs.finalprojectkade.Model.retrofit.RetrofitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NextMatchesPresenter(val nextMatchViews: NextMatchViews){

    fun getLeague(){
        val apiClientRetrofit = RetrofitResponse().response()
        apiClientRetrofit.getLeague().enqueue(object : Callback<ResponseValue>{
            override fun onFailure(call: Call<ResponseValue>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseValue>, response: Response<ResponseValue>) {
                val data = response.body()
                if (data != null){
                    nextMatchViews.showLeagues(data.countrys)
                }
            }

        })
    }

    fun getEvents(id:String){
        val apiClientRetrofit = RetrofitResponse().response()
        apiClientRetrofit.getEventsNextLeague(id).enqueue(object : Callback<ResponseValue>{
            override fun onFailure(call: Call<ResponseValue>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseValue>, response: Response<ResponseValue>) {
                val data = response.body()
                if (data != null){
                    nextMatchViews.showEvents(data.events)
                }
            }

        })
    }

}