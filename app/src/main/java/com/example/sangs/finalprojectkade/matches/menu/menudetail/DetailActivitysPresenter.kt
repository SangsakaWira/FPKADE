package com.example.sangs.finalprojectkade.matches.menu.menudetail

import com.example.sangs.finalprojectkade.Model.model.ResponseValue
import com.example.sangs.finalprojectkade.Model.retrofit.RetrofitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivitysPresenter(val detailActivitysView: DetailActivitysView){


    //    fun getFavoriteSize(id:String){
//        detailView.showLoading()
//        database.use {
//            val result = select(Favourite.TABLE_FAVORITE)
//                .whereArgs("(TEAM_ID_EVENT = {id})",
//                    "id" to id)
//            val favorite = result.parseList(classParser<Favourite>())
//            if (!favorite.isEmpty()){
//                detailView.getFavouriteSize(true)
//            }else{
//                detailView.getFavouriteSize(false)
//            }
//        }
//        detailView.hideLoading()
//    }
//
    fun showImgDataItems(idHome:String,idAway:String){
        val apiClientRetrofit = RetrofitResponse().response()
        apiClientRetrofit.getEventsTeam(idHome).enqueue(object : Callback<ResponseValue> {
            override fun onFailure(call: Call<ResponseValue>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseValue>, response: Response<ResponseValue>) {
                val data = response.body()
                if (data != null){
                    detailActivitysView.setImageHome(data.teams?.get(0)!!.strTeamBadge)
                }
            }
        })
        apiClientRetrofit.getEventsTeam(idAway).enqueue(object : Callback<ResponseValue> {
            override fun onFailure(call: Call<ResponseValue>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseValue>, response: Response<ResponseValue>) {
                val data = response.body()
                if (data != null){
                    detailActivitysView.setImageAway(data.teams?.get(0)!!.strTeamBadge)
                }
            }
        })

    }
//
//    fun removeFromFavorite(ids:String){
//        detailView.showLoading()
//        try {
//            database.use {
//                delete(Favourite.TABLE_FAVORITE, "TEAM_ID_EVENT = {userID}", "userID" to ids)
//            }
//            detailView.hideLoading()
//        } catch (e: SQLiteConstraintException){
//            detailView.hideLoading()
//        }
//    }
//    fun addToFavorite(id_event:String,
//                      awayTeam:String,
//                      homeTeam:String,
//                      dateEvent:String,
//                      scoreHome:String,
//                      scoreAway:String,
//                      paramsID:String){
//        detailView.showLoading()
//        try {
//            database.use {
//                insert(
//                    Favourite.TABLE_FAVORITE,
//                    Favourite.TEAM_ID_EVENT to id_event,
//                    Favourite.TEAM_AWAY to awayTeam,
//                    Favourite.TEAM_HOME to homeTeam,
//                    Favourite.TEAM_DATE_EVENT to dateEvent,
//                    Favourite.TEAM_SCORE_HOME to scoreHome,
//                    Favourite.TEAM_SCORE_AWAY to scoreAway,
//                    Favourite.TEAM_PARAMETER_ID to paramsID)
//            }
//            detailView.hideLoading()
//        } catch (e: SQLiteConstraintException){
//            detailView.hideLoading()
//        }
//    }
//
    fun showDetailDataItems(id:String, param:String){
        val apiClientRetrofit = RetrofitResponse().response()
        apiClientRetrofit.getEventsDetail(id).enqueue(object : Callback<ResponseValue> {
            override fun onFailure(call: Call<ResponseValue>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseValue>, response: Response<ResponseValue>) {
                val data = response.body()
                if (data != null){
                    detailActivitysView.setDataItems(data.events?.get(0),param)
                    showImgDataItems(data.events?.get(0)!!.idHomeTeam,data.events?.get(0)!!.idAwayTeam)
                }
            }

        })

    }

}