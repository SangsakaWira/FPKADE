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
    var idEvent:String="",
    @SerializedName("strHomeGoalDetails")
    var strHomeGoalDetails:String="",
    @SerializedName("strHomeLineupGoalkeeper")
    var strHomeLineupGoalkeeper:String="",
    @SerializedName("strHomeLineupDefense")
    var strHomeLineupDefense:String="",
    @SerializedName("strHomeLineupMidfield")
    var strHomeLineupMidfield:String="",
    @SerializedName("strHomeLineupForward")
    var strHomeLineupForward:String="",
    @SerializedName("strHomeLineupSubstitutes")
    var strHomeLineupSubstitutes:String="",
    @SerializedName("strAwayGoalDetails")
    var  strAwayGoalDetails:String="",
    @SerializedName("strAwayLineupGoalkeeper")
    var strAwayLineupGoalkeeper:String="",
    @SerializedName("strAwayLineupDefense")
    var strAwayLineupDefense:String="",
    @SerializedName("strAwayLineupMidfield")
    var strAwayLineupMidfield:String="",
    @SerializedName("strAwayLineupForward")
    var strAwayLineupForward:String="",
    @SerializedName("strAwayLineupSubstitutes")
    var strAwayLineupSubstitutes:String="",
    @SerializedName("intHomeShots")
    var intHomeShots:String="",
    @SerializedName("intAwayShots")
    var intAwayShots:String="",
    @SerializedName("idHomeTeam")
    var idHomeTeam:String="",
    @SerializedName("idAwayTeam")
    var idAwayTeam:String="",
    @SerializedName("strTeam")
    val strTeam:String="",
    @SerializedName("strTeamBadge")
    val strTeamBadge:String="",
    @SerializedName("idTeam")
    val idTeam:String="",
    @SerializedName("intFormedYear")
    val intFormedYear:String="",
    @SerializedName("strStadium")
    val strStadium:String = "",
    @SerializedName("strDescriptionEN")
    val strDescriptionEN:String = "",
    @SerializedName("strPlayer")
    val strPlayer:String = "",
    @SerializedName("strPosition")
    val strPosition:String = "",
    @SerializedName("strCutout")
    val strCutout:String = "",
    @SerializedName("idPlayer")
    val idPlayer:String="",
    @SerializedName("strHeight")
    val strHeight:String ="",
    @SerializedName("strWeight")
    val strWeight:String = "",
    @SerializedName("strThumb")
    val strThumb:String = ""
)