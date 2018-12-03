package com.example.sangs.finalprojectkade.teams.detail

import com.example.sangs.finalprojectkade.Model.model.ResponseValue
import com.example.sangs.finalprojectkade.Model.retrofit.RetrofitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailItemPresenter(val detailItemViews: DetailItemViews) {

    fun getInformationTeams(id:String){
        val apiClientRetrofit = RetrofitResponse().response()
        apiClientRetrofit.getInfoTeams(id).enqueue(object : Callback<ResponseValue> {
            override fun onFailure(call: Call<ResponseValue>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseValue>, response: Response<ResponseValue>) {
                val data = response.body()
                if (data != null){
                    detailItemViews.showDataItems(data.teams)
                }
            }

        })
    }

}