package com.example.sangs.finalprojectkade.teams.detail.menu.overviewmatch

import android.widget.TextView
import com.example.sangs.finalprojectkade.Model.model.ResponseValue
import com.example.sangs.finalprojectkade.Model.retrofit.RetrofitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewsPresenter {

    fun getInfoTeams(id:String,textView: TextView){
        val apiClientRetrofit = RetrofitResponse().response()
        var datas:String= ""
        apiClientRetrofit.getInfoTeams(id).enqueue(object : Callback<ResponseValue> {
            override fun onFailure(call: Call<ResponseValue>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseValue>, response: Response<ResponseValue>) {
                val data = response.body()
                if (data != null){
                    textView.text = data.teams?.get(0)!!.strDescriptionEN
                }
            }

        })

    }

}