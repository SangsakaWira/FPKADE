package com.example.sangs.finalprojectkade.Model.retrofit

import com.example.sangs.finalprojectkade.Model.model.ResponseValue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface APIClientRetrofit {


    @GET("search_all_leagues.php?s=Soccer")
    fun getLeague(): Call<ResponseValue>


    @GET("lookup_all_teams.php")
    fun getTeams(@Query("id")id:String):Call<ResponseValue>

    @GET("lookupteam.php")
    fun getInfoTeams(@Query("id")id:String):Call<ResponseValue>

    @GET("eventsnextleague.php")
    fun getEventsNextLeague(@Query("id")id:String):Call<ResponseValue>

    @GET("eventspastleague.php")
    fun getEventsPastLeague(@Query("id")id:String):Call<ResponseValue>

    @GET("lookup_all_players.php")
    fun getAllPlayers(@Query("id")id:String):Call<ResponseValue>

    @GET("lookupplayer.php")
    fun getPlayers(@Query("id")id:String):Call<ResponseValue>

    @GET("lookupevent.php")
    fun getEventsDetail(@Query("id")id:String):Call<ResponseValue>

    @GET("lookupteam.php")
    fun getEventsTeam(@Query("id")id:String):Call<ResponseValue>

}