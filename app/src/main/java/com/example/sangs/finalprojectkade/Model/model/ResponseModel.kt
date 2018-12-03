package com.example.sangs.finalprojectkade.Model.model

import com.google.gson.annotations.SerializedName

class ResponseModel(
    @SerializedName("idLeague")
    val idLeague:String = "",
    @SerializedName("strLeague")
    val strLeague:String = "",
    @SerializedName("strHomeTeam")
    val strHomeTeam:String = "",
    @SerializedName("strAwayTeam")
    val strAwayTeam:String = "",
    @SerializedName("dateEvent")
    val dateEvent:String = "",
    @SerializedName("strTime")
    val strTime:String="",
    @SerializedName("intHomeScore")
    val intHomeScore:String = "",
    @SerializedName("intAwayScore")
    val intAwayScore:String="",
    @SerializedName("idEvent")
    var idEvent:String=""
)