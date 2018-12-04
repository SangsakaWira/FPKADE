package com.example.sangs.finalprojectkade.matches.menu.menudetail

import android.database.sqlite.SQLiteConstraintException
import com.example.sangs.finalprojectkade.Model.db.Favorite
import com.example.sangs.finalprojectkade.Model.db.MyDatabaseOpenHelper
import com.example.sangs.finalprojectkade.Model.model.ResponseValue
import com.example.sangs.finalprojectkade.Model.retrofit.RetrofitResponse
import kotlinx.coroutines.selects.select
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivitysPresenter(val detailActivitysView: DetailActivitysView,
                               val database: MyDatabaseOpenHelper){


    fun getFavoriteSize(id:String){
        database.use {
            val result = select(Favorite.TABLE_FAVORITE)
                .whereArgs("(idEvent = {id})",
                    "id" to id)
            val favorite = result.parseList(classParser<Favorite>())
            if (!favorite.isEmpty()){
                detailActivitysView.getMatchesSize(true)
            }else{
                detailActivitysView.getMatchesSize(false)
            }
        }
    }

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
    fun removeFromFavorite(ids:String){

        try {
            database.use {
                delete(Favorite.TABLE_FAVORITE, "idEvent = {userID}", "userID" to ids)
            }

        } catch (e: SQLiteConstraintException){

        }
    }
    fun addToFavorite(id_event:String,
                      awayTeam:String,
                      homeTeam:String,
                      dateEvent:String,
                      scoreHome:String,
                      scoreAway:String,
                      paramsID:String){

        try {
            database.use {
                insert(
                    Favorite.TABLE_FAVORITE,
                    Favorite.idEvent to id_event,
                    Favorite.strAwayTeam to awayTeam,
                    Favorite.strHomeTeam to homeTeam,
                    Favorite.dateEvent to dateEvent,
                    Favorite.intHomeScore to scoreHome,
                    Favorite.intAwayScore to scoreAway,
                    Favorite.TEAM_PARAMETER_ID to paramsID)
            }
        } catch (e: SQLiteConstraintException){
        }
    }

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