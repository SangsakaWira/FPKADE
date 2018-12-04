package com.example.sangs.finalprojectkade.teams.detail

import android.database.sqlite.SQLiteConstraintException
import android.widget.TextView
import com.example.sangs.finalprojectkade.Model.db.MyDatabaseOpenHelper
import com.example.sangs.finalprojectkade.Model.db.Teams
import com.example.sangs.finalprojectkade.Model.model.ResponseValue
import com.example.sangs.finalprojectkade.Model.retrofit.RetrofitResponse
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailItemPresenter(val detailItemViews: DetailItemViews,
                          val myDatabaseOpenHelper: MyDatabaseOpenHelper) {

    fun getFavoriteSize(id:String){
        myDatabaseOpenHelper.use {
            val result = select(Teams.TABLE_TEAMS)
                .whereArgs("(idTeam = {id})",
                    "id" to id)
            val favorite = result.parseList(classParser<Teams>())
            if (!favorite.isEmpty()){
                detailItemViews.getFavouriteSize(true)
            }else{
                detailItemViews.getFavouriteSize(false)
            }
        }
    }

    fun removeFromFavorite(ids:String){
        try {
            myDatabaseOpenHelper.use {
                delete(Teams.TABLE_TEAMS, "idTeam = {userID}", "userID" to ids)
            }
        } catch (e: SQLiteConstraintException){

        }
    }
    fun addToFavorite(idTeam:String, teamLogo:String, teamName:String){
        try {
            myDatabaseOpenHelper.use {
                insert(
                    Teams.TABLE_TEAMS,
                    Teams.idTeam to idTeam,
                    Teams.strTeam to teamName,
                    Teams.strTeamBadge to teamLogo
                )
            }

        } catch (e: SQLiteConstraintException){
        }
    }

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